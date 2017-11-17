// A program to select the songs with the highest 
// quality score according to Zipf's Law
// (c) 2017 Bryan C. Bailey

import java.util.*;

public class zipf {


    public static void main( String[] args ) {
	
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int m = in.nextInt();
	int albumListens=0;
	HashMap<String, Double> albumSongs = new LinkedHashMap<String, Double>();

	for( int i=0; i<n; i++ ) {
	    double listens = in.nextInt();
	    albumListens+=listens;
	    String songName = in.next();
	    albumSongs.put( songName, listens );
	}
	
	double trackNumber = 1.0;
	TreeMap<Double, String> zipfSongs = new TreeMap<Double, String>(Collections.reverseOrder());
	for( String song: albumSongs.keySet() ) {
	    double fi = albumSongs.get(song)/(double)albumListens;
	    double zi = 1/trackNumber;
	    double qi = fi/zi;
	    zipfSongs.put( qi, song );
	    trackNumber++;
	}
	
	int exit = 0;
	for( double quality: zipfSongs.keySet() ) {
	    System.out.println( zipfSongs.get(quality));
	    if( ++exit==m ) return;
	}
    }
}