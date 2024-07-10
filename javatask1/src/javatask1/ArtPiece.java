package javatask1;

public class ArtPiece {
    private int artPieceId;
    private String title;
    private int artistId;
    private String description;
    private int year;

    // Constructor
    public ArtPiece(int artPieceId, String title, int artistId, String description, int year) {
        this.artPieceId = artPieceId;
        this.title = title;
        this.artistId = artistId;
        this.description = description;
        this.year = year;
    }

    // Getters and Setters
    public int getArtPieceId() {
        return artPieceId;
    }

    public void setArtPieceId(int artPieceId) {
        this.artPieceId = artPieceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
