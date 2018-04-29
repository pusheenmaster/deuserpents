import java.util.*;
import java.io.*;

public class HighscoreManager {
    
    private ArrayList<Score> scores;

    
    private static final String HIGHSCORE_FILE = "scores.dat";

    
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;

    public HighscoreManager() {
        
        scores = new ArrayList<Score>();
    }
    
    public ArrayList<Score> getScores() {
        loadScoreFile();
        sort();
        return scores;
    }
    
    private void sort() {
        ScoreComparator comparator = new ScoreComparator();
        Collections.sort(scores, comparator);
	}
	
	public void addScore(String name, int score) {
        loadScoreFile();
        int oldScore = 0;
        boolean test = false;
        if (scores.size() == 0) {
			scores.add(new Score(name, score));
			test = true;
			//System.out.println("added in zero "  + name);
		}
		if (test == false) {
			for (int i=0; i< scores.size(); i++) {
				//System.out.println("Name checking:"  + scores.get(i).getNom() + "=" + name);
				if (scores.get(i).getNom().equals(name)) {
					oldScore = scores.get(i).getScore();
					//System.out.println("removed" + scores.get(i).getNom());
					scores.remove(i);
					scores.add(new Score(name, oldScore + score));
					test = true;
					//System.out.println("added "  + name + "oldscore = " + oldScore + "newscore: " + score + "totalfinalscore = "+ (oldScore + score));
					break;
				}
			}
		}	
        
		if (test == false) {
			scores.add(new Score(name, score));
			//System.out.println("added  IN LAST CHECK "  + name);
		}
        updateScoreFile();
	}
	
	public void loadScoreFile() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
            scores = (ArrayList<Score>) inputStream.readObject();
        } catch (FileNotFoundException e) {         
        } catch (IOException e) {            
        } catch (ClassNotFoundException e) {           
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {                
            }
        }
	}
	
	public void updateScoreFile() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
            outputStream.writeObject(scores);
        } catch (FileNotFoundException e) {          
        } catch (IOException e) { 
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {        
            }
        }
	}
	
	public String getHighscoreString() {
        String highscoreString = "";
		int max = 10;

        ArrayList<Score> scores;
        scores = getScores();

        int i = 0;
        int x = scores.size();
        if (x > max) {
            x = max;
        }
        while (i < x) {
            highscoreString += (i + 1) + ".\t " + scores.get(i).getNom() + "\t\t " + scores.get(i).getScore() + "\n";
            i++;
        }
        return highscoreString;
	}
}
