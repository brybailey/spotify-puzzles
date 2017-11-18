// A program to select the songs with the highest 
// quality score according to Zipf's Law
// (c) 2017 Bryan C. Bailey

import java.util.*;

public class zipf {

    // The total number of listens for all the songs on the album
    static int albumListens;
    
    // Put all the songs and their number of listens in a hashmap
    // Set the albumListens
    private static HashMap<String, Double> gatherSongs( Scanner in, int n ) {
	albumListens = 0;
	HashMap<String, Double> albumSongs = new LinkedHashMap<String, Double>();
	for( int i=0; i<n; i++ ) {
	    double listens = in.nextInt();
	    albumListens+=listens;
	    String songName = in.next();
	    albumSongs.put( songName, listens );
	}

	return albumSongs;
    }

    // Compute the relative Zipf scores of all the songs
    private static TreeMap<Double, String> computeZipfScores( HashMap<String, Double> albumSongs ) {
	double trackNumber = 1.0;
	TreeMap<Double, String> zipfSongs = new TreeMap<Double, String>(Collections.reverseOrder());
	for( String song: albumSongs.keySet() ) {
	    // Computes relative number of listens of songs compared to their expected number of listens
	    double fi = albumSongs.get(song)/(double)albumListens;
	    // For the full formula, this would be multiplied by the total number of listens to arrive
	    // At the expected number of listens, but since its relative this number is inconsequential
	    double zi = 1/trackNumber;
	    double qi = fi/zi;
	    zipfSongs.put( qi, song );
	    trackNumber++;
	}

	return zipfSongs; 
    }

    public static void main( String[] args ) {
	
	Scanner in = new Scanner(System.in);
	// Number of songs in the album
	int n = in.nextInt();
	// Number of songs to print
	int m = in.nextInt();
	
	HashMap<String, Double> albumSongs = gatherSongs(in, n);
	TreeMap<Double, String> zipfSongs = computeZipfScores( albumSongs );
	int exit = 0;
	// This loop can be improved
	for( double quality: zipfSongs.keySet() ) {
	    System.out.println( zipfSongs.get(quality));
	    if( ++exit==m ) return;
	}
    }
}