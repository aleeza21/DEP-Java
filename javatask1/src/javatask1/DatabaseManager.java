package javatask1;

import java.sql.*;

public class DatabaseManager {

    private static final String url = "jdbc:mysql://localhost:3307/artgallery";
    private static final String user = "root";
    private static final String pass = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }

    // CRUD operations for Artist
    public static void addArtist(String name, String bio) throws SQLException {
        String query = "INSERT INTO artists (name, bio) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setString(2, bio);
            pstmt.executeUpdate();
            System.out.println("Artist added successfully.");
        }
    }

    public static void updateArtist(int artistId, String name, String bio) throws SQLException {
        String query = "UPDATE artists SET name = ?, bio = ? WHERE artist_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setString(2, bio);
            pstmt.setInt(3, artistId);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Artist updated successfully.");
            } else {
                System.out.println("No artist found with ID " + artistId);
            }
        }
    }

    public static void deleteArtist(int artistId) throws SQLException {
        String query = "DELETE FROM artists WHERE artist_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, artistId);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Artist deleted successfully.");
            } else {
                System.out.println("No artist found with ID " + artistId);
            }
        }
    }

    public static void DispArtists() throws SQLException {
        String query = "SELECT * FROM artists";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            boolean found = false;
            while (rs.next()) {
                found = true;
                int id = rs.getInt("artist_id");
                String name = rs.getString("name");
                String bio = rs.getString("bio");
                System.out.println("Artist ID: " + id + ", Name: " + name + ", Bio: " + bio);
            }
            if (!found) {
                System.out.println("No artists found.");
            }
        }
    }

    // CRUD operations for ArtPiece
    public static void addArtPiece(String title, String artistName, String description, int year) throws SQLException {
        // Getting artist ID based on artist name
        int artistId = getArtistIdByName(artistName);
        if (artistId == -1) {
            System.out.println("Artist with name '" + artistName + "' not found.");
            return;
        }

        String query = "INSERT INTO art_pieces (title, artist_id, description, year) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, title);
            pstmt.setInt(2, artistId);
            pstmt.setString(3, description);
            pstmt.setInt(4, year);
            pstmt.executeUpdate();
            System.out.println("Art piece added successfully.");
        }
    }

    public static void updateArtPiece(int artPieceId, String title, String artistName, String description, int year) throws SQLException {
        // Getting artist ID based on artist name
        int artistId = getArtistIdByName(artistName);
        if (artistId == -1) {
            System.out.println("Artist with name '" + artistName + "' not found.");
            return;
        }

        String query = "UPDATE art_pieces SET title = ?, artist_id = ?, description = ?, year = ? WHERE art_piece_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, title);
            pstmt.setInt(2, artistId);
            pstmt.setString(3, description);
            pstmt.setInt(4, year);
            pstmt.setInt(5, artPieceId);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Art piece updated successfully.");
            } else {
                System.out.println("No art piece found with ID " + artPieceId);
            }
        }
    }

    public static void deleteArtPiece(int artPieceId) throws SQLException {
        String query = "DELETE FROM art_pieces WHERE art_piece_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, artPieceId);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Art piece deleted successfully.");
            } else {
                System.out.println("No art piece found with ID " + artPieceId);
            }
        }
    }

    public static void DispArtPieces() throws SQLException {
        String query = "SELECT * FROM art_pieces";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            boolean found = false;
            while (rs.next()) {
                found = true;
                int id = rs.getInt("art_piece_id");
                String title = rs.getString("title");
                int artistId = rs.getInt("artist_id");
                String description = rs.getString("description");
                int year = rs.getInt("year");
                System.out.println("Art Piece ID: " + id + ", Title: " + title + ", Artist ID: " + artistId + ", Description: " + description + ", Year: " + year);
            }
            if (!found) {
                System.out.println("No art pieces found.");
            }
        }
    }

    // CRUD operations for Exhibition
    public static void addExhibition(String name, String startDate, String endDate, String description) throws SQLException {
        String query = "INSERT INTO exhibitions (name, start_date, end_date, description) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setString(2, startDate);
            pstmt.setString(3, endDate);
            pstmt.setString(4, description);
            pstmt.executeUpdate();
            System.out.println("Exhibition added successfully.");
        }
    }

    public static void updateExhibition(int exhibitionId, String name, String startDate, String endDate, String description) throws SQLException {
        String query = "UPDATE exhibitions SET name = ?, start_date = ?, end_date = ?, description = ? WHERE exhibition_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setString(2, startDate);
            pstmt.setString(3, endDate);
            pstmt.setString(4, description);
            pstmt.setInt(5, exhibitionId);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Exhibition updated successfully.");
            } else {
                System.out.println("No exhibition found with ID " + exhibitionId);
            }
        }
    }

    public static void deleteExhibition(int exhibitionId) throws SQLException {
        String query = "DELETE FROM exhibitions WHERE exhibition_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, exhibitionId);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Exhibition deleted successfully.");
            } else {
                System.out.println("No exhibition found with ID " + exhibitionId);
            }
        }
    }

    public static void DispExhibitions() throws SQLException {
        String query = "SELECT * FROM exhibitions";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            boolean found = false;
            while (rs.next()) {
                found = true;
                int id = rs.getInt("exhibition_id");
                String name = rs.getString("name");
                String startDate = rs.getString("start_date");
                String endDate = rs.getString("end_date");
                String description = rs.getString("description");
                System.out.println("Exhibition ID: " + id + ", Name: " + name + ", Start Date: " + startDate + ", End Date: " + endDate + ", Description: " + description);
            }
            if (!found) {
                System.out.println("No exhibitions found.");
            }
        }
    }

    // method to get artist ID by name
    private static int getArtistIdByName(String artistName) throws SQLException {
        String query = "SELECT artist_id FROM artists WHERE name = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, artistName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("artist_id");
            }
            return -1; //If artist is not found
        }
    }
}
