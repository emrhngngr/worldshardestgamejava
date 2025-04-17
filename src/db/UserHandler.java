package db;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicInteger;


public class UserHandler {
    private String username;
    private String password;

    public UserHandler(String username, String password) {
        this.username = username;
        // Encryption process to store password securely
        this.password = hashPassword(password);
    }
    public UserHandler(){
        //Use an empty constructure to use other functions
    }

    public boolean registerUser() {
        if (isUsernameTaken(this.username)) {
            return false; // Username is already taken
        }

        String query = "INSERT INTO users (username, password) VALUES (?, ?)";

        try {
            Connect connection = new Connect();
            connection.connection.setAutoCommit(false);  // Start transaction

            connection.executeQuery(query, preparedStatement -> {
                preparedStatement.setString(1, this.username);
                preparedStatement.setString(2, this.password);
                preparedStatement.executeUpdate();
            });

            connection.connection.commit();  // Complete the transaction
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //Does the entered username exist in the database?
    private boolean isUsernameTaken(String username) {
        String query = "SELECT COUNT(*) AS count FROM users WHERE username = ?";

        try {
            Connect connection = new Connect();
            AtomicInteger count = new AtomicInteger(0);

            connection.executeQuery(query, preparedStatement -> {
                preparedStatement.setString(1, username);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    count.set(resultSet.getInt("count"));
                }
            });

            // If count is greater than 0, the username is taken
            return count.get() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return true; // Assume username is taken in case of an error
        }
    }



    public int getUserID(String username) {
        String query = "SELECT user_id FROM users WHERE username = ?";
        AtomicInteger userID = new AtomicInteger(-1);  // Default value if user not found

        try {
            Connect connection = new Connect();
            connection.executeQuery(query, preparedStatement -> {
                preparedStatement.setString(1, username);  // Use the parameter 'username'
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    userID.set(resultSet.getInt("user_id"));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userID.get();
    }



    public void addToLeaderBoard(int userID, double maxTime) {
        String query = "INSERT INTO userstats (user_id, time) VALUES (?, ?)";

        try {
            Connect connection = new Connect();
            connection.connection.setAutoCommit(false);  // Start transaction

            connection.executeQuery(query, preparedStatement -> {
                preparedStatement.setInt(1, userID);
                preparedStatement.setDouble(2, maxTime);
                preparedStatement.executeUpdate();
            });

            connection.connection.commit();  // Complete the transaction
            System.out.println("Added"+ userID+maxTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public double getRecordTime(String username){
        int userId = getUserID(username);
        String query = "SELECT time FROM userstats WHERE user_id = ?";
        AtomicInteger userID = new AtomicInteger(-1);  // Default value if user not found

        try {
            Connect connection = new Connect();
            connection.executeQuery(query, preparedStatement -> {
                preparedStatement.setInt(1, userId);  // Use the parameter 'username'
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    userID.set(resultSet.getInt("time"));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userID.get();
    }
    public boolean checkRecordOrNot(String username, double currentTime) {

        double maxTime = getRecordTime(username);

        if (currentTime < maxTime) {
            // The current time is a new record, update the user's record in the database
            int userId = getUserID(username);
            updateMaxTime(userId, currentTime);
            return true;
        }else {
            return false;
        }

    }
    private void updateMaxTime(int userId, double currentTime) {
        String query = "UPDATE userstats SET time = ? WHERE user_id = ?";
        System.out.printf(query);
        try {
            Connect connection = new Connect();
            connection.executeQuery(query, preparedStatement -> {
                preparedStatement.setDouble(1, currentTime);
                preparedStatement.setInt(2, userId);
                preparedStatement.executeUpdate();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());

            // Convert hash to hexadecimal format
            StringBuilder hexStringBuilder = new StringBuilder();
            for (byte b : hashedBytes) {
                hexStringBuilder.append(String.format("%02x", b));
            }

            return hexStringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return password;  // Use password as plaintext on error
        }
    }
}
