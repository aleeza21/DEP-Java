package javatask1;

import java.sql.SQLException;
import java.util.Scanner;

public class ArtGallery {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCRUD;

        do {
            System.out.println("\nArt Gallery Manager");
            System.out.println("1. Manage Artists");
            System.out.println("2. Manage Art Pieces");
            System.out.println("3. Manage Exhibitions");
            System.out.println("4. Display All Data");
            System.out.println("5. Exit");
            System.out.print("Choose what do you want to perform: ");

            int ch = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            try {
                switch (ch) {
                    case 1:
                        manageArtists(scanner);
                        break;
                    case 2:
                        manageArtPieces(scanner);
                        break;
                    case 3:
                        manageExhibitions(scanner);
                        break;
                    case 4:
                        DispAllData();
                        break;
                    case 5:
                        System.out.println("\nThank you for using Art Gallery Manager. Goodbye!");
                        return;  // Exit the program
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            System.out.print("\nDo you want to continue with CRUD operations? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            continueCRUD = response.equals("yes");

            if (!continueCRUD) {
                System.out.println("\nThank you for using Art Gallery Manager. Goodbye!");
            }

        } while (continueCRUD);

        scanner.close();
    }

    private static void manageArtists(Scanner scanner) throws SQLException {
        System.out.println("\nManage Artists");
        System.out.println("1. Add Artist");
        System.out.println("2. Update Artist");
        System.out.println("3. Delete Artist");
        System.out.println("4. Display Artists");
        System.out.print("Choose from the above options: ");

        int ch = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (ch) {
            case 1:
                System.out.print("Enter artist name: ");
                String artistName = scanner.nextLine();
                System.out.print("Enter artist bio: ");
                String artistBio = scanner.nextLine();
                DatabaseManager.addArtist(artistName, artistBio);
                break;
            case 2:
                System.out.print("Enter artist ID to update: ");
                int artistIdToUpdate = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                System.out.print("Enter new artist name: ");
                String newArtistName = scanner.nextLine();
                System.out.print("Enter new artist bio: ");
                String newArtistBio = scanner.nextLine();
                DatabaseManager.updateArtist(artistIdToUpdate, newArtistName, newArtistBio);
                break;
            case 3:
                System.out.print("Enter artist ID to delete: ");
                int artistIdToDelete = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                DatabaseManager.deleteArtist(artistIdToDelete);
                break;
            case 4:
                DatabaseManager.DispArtists();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void manageArtPieces(Scanner scanner) throws SQLException {
        System.out.println("\nManage Art Pieces");
        System.out.println("1. Add Art Piece");
        System.out.println("2. Update Art Piece");
        System.out.println("3. Delete Art Piece");
        System.out.println("4. Display Art Pieces");
        System.out.print("Choose from the above options: ");

        int ch = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (ch) {
            case 1:
                System.out.print("Enter art piece title: ");
                String artPieceTitle = scanner.nextLine();
                System.out.print("Enter artist name for this art piece: ");
                String artPieceArtistName = scanner.nextLine();
                System.out.print("Enter art piece description: ");
                String artPieceDescription = scanner.nextLine();
                System.out.print("Enter art piece year: ");
                int artPieceYear = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                DatabaseManager.addArtPiece(artPieceTitle, artPieceArtistName, artPieceDescription, artPieceYear);
                break;
            case 2:
                System.out.print("Enter art piece ID to update: ");
                int artPieceIdToUpdate = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                System.out.print("Enter new art piece title: ");
                String newArtPieceTitle = scanner.nextLine();
                System.out.print("Enter new artist name for this art piece: ");
                String newArtPieceArtistName = scanner.nextLine();
                System.out.print("Enter new art piece description: ");
                String newArtPieceDescription = scanner.nextLine();
                System.out.print("Enter new art piece year: ");
                int newArtPieceYear = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                DatabaseManager.updateArtPiece(artPieceIdToUpdate, newArtPieceTitle, newArtPieceArtistName, newArtPieceDescription, newArtPieceYear);
                break;
            case 3:
                System.out.print("Enter art piece ID to delete: ");
                int artPieceIdToDelete = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                DatabaseManager.deleteArtPiece(artPieceIdToDelete);
                break;
            case 4:
                DatabaseManager.DispArtPieces();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void manageExhibitions(Scanner scanner) throws SQLException {
        System.out.println("\nManage Exhibitions");
        System.out.println("1. Add Exhibition");
        System.out.println("2. Update Exhibition");
        System.out.println("3. Delete Exhibition");
        System.out.println("4. Display Exhibitions");
        System.out.print("Choose from the above options: ");

        int ch = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (ch) {
            case 1:
                System.out.print("Enter exhibition name: ");
                String exhibitionName = scanner.nextLine();
                System.out.print("Enter exhibition start date (YYYY-MM-DD): ");
                String exhibitionStartDate = scanner.nextLine();
                System.out.print("Enter exhibition end date (YYYY-MM-DD): ");
                String exhibitionEndDate = scanner.nextLine();
                System.out.print("Enter exhibition description: ");
                String exhibitionDescription = scanner.nextLine();
                DatabaseManager.addExhibition(exhibitionName, exhibitionStartDate, exhibitionEndDate, exhibitionDescription);
                break;
            case 2:
                System.out.print("Enter exhibition ID to update: ");
                int exhibitionIdToUpdate = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                System.out.print("Enter new exhibition name: ");
                String newExhibitionName = scanner.nextLine();
                System.out.print("Enter new exhibition start date (YYYY-MM-DD): ");
                String newExhibitionStartDate = scanner.nextLine();
                System.out.print("Enter new exhibition end date (YYYY-MM-DD): ");
                String newExhibitionEndDate = scanner.nextLine();
                System.out.print("Enter new exhibition description: ");
                String newExhibitionDescription = scanner.nextLine();
                DatabaseManager.updateExhibition(exhibitionIdToUpdate, newExhibitionName, newExhibitionStartDate, newExhibitionEndDate, newExhibitionDescription);
                break;
            case 3:
                System.out.print("Enter exhibition ID to delete: ");
                int exhibitionIdToDelete = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                DatabaseManager.deleteExhibition(exhibitionIdToDelete);
                break;
            case 4:
                DatabaseManager.DispExhibitions();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void DispAllData() throws SQLException {
        System.out.println("\nArtists:");
        DatabaseManager.DispArtists();
        System.out.println("\nArt Pieces:");
        DatabaseManager.DispArtPieces();
        System.out.println("\nExhibitions:");
        DatabaseManager.DispExhibitions();
    }
}
