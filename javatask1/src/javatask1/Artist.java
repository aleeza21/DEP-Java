package javatask1;

public class Artist {
    private int artistId;
    private String name;
    private String bio;

    // Constructor
    public Artist(int artistId, String name, String bio) {
        this.artistId = artistId;
        this.name = name;
        this.bio = bio;
    }

    // Getters and Setters
    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
