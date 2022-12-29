package HomeWork8;

import HomeWork8.entity.WeatherDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseRepository {
    private String insertWeather = "insert into weather (city, localdate, temperature) values (?, ?, ?)";
    private String getWeatherDB = "select * from weather";
    private static final String DB_PATH = "jdbc:sqlite:gb.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean saveWeatherToDB(WeatherDB weatherDB) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            saveWeather.setString(1, weatherDB.getCity());
            saveWeather.setString(2, weatherDB.getLocalDate());
            saveWeather.setDouble(3, weatherDB.getTemperature());
            return saveWeather.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Сохранение погоды в БД не выполнено!");
    }

    public void saveWeatherToDB(List<WeatherDB> weatherDBList) throws SQLException{
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            for (WeatherDB weatherDB : weatherDBList) {
                saveWeather.setString(1, weatherDB.getCity());
                saveWeather.setString(2, weatherDB.getLocalDate());
                saveWeather.setDouble(3, weatherDB.getTemperature());
                saveWeather.addBatch();
            }
            saveWeather.executeBatch();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<WeatherDB> getSavedToDBWeather() {
        List<WeatherDB> weatherDBList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_PATH)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getWeatherDB);
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id"));
                System.out.println(" ");
                System.out.print(resultSet.getString("city"));
                System.out.println(" ");
                System.out.print(resultSet.getString("localdate"));
                System.out.println(" ");
                System.out.print(resultSet.getDouble("temperature"));
                System.out.println(" ");
                weatherDBList.add(new WeatherDB(resultSet.getString("city"),
                        resultSet.getString("localdate"),
                        resultSet.getDouble("temperature")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return weatherDBList;
    }
}
