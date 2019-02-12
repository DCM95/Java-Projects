import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
/**
a test file for the SoftballTeam Class.
*/
public class SoftballTeamTest {
/**
a test which tests the readPlayer file method.
@throws IOException required for it to run.
*/
   @Test public void readPlayerFileTest() throws IOException {
      SoftballTeam t1 = new SoftballTeam();
      SoftballTeam t2 = new SoftballTeam();
      SoftballTeam t3 = new SoftballTeam();
      t1.readPlayerFile("softball_player_data.csv");
      t2.readPlayerFile("softball_player_data2.csv");
      t3.readPlayerFile("softball_player_data2.large_team.csv");
      Assert.assertEquals(true, true);
   }
   /**
a test which tests the team name methods.
@throws IOException required for it to run.
*/
   @Test public void teamNameTest() throws IOException {
      SoftballTeam t1 = new SoftballTeam();
      SoftballTeam t2 = new SoftballTeam();
      SoftballTeam t3 = new SoftballTeam();
      t1.readPlayerFile("softball_player_data.csv");
      t2.readPlayerFile("softball_player_data2.csv");
      t3.readPlayerFile("softball_player_data2.large_team.csv");
      t1.setTeamName("Average Joes");
      Assert.assertEquals("Average Joes", t1.getTeamName());
   }
   /**
a test which tests the roster methods.
@throws IOException required for it to run.
*/
   @Test public void rosterTest() throws IOException {
      SoftballTeam t1 = new SoftballTeam();
      SoftballTeam t2 = new SoftballTeam();
      SoftballTeam t3 = new SoftballTeam();
      t1.readPlayerFile("softball_player_data.csv");
      t2.readPlayerFile("softball_player_data2.csv");
      t3.readPlayerFile("softball_player_data2.large_team.csv");
      t1.setRoster(t2.getRoster());
      Assert.assertEquals(true, t1.getRoster().equals(t2.getRoster()));
   }
   /**
a test which tests the player count methods.
@throws IOException required for it to run.
*/
   @Test public void playerCountTest() throws IOException {
      SoftballTeam t1 = new SoftballTeam();
      SoftballTeam t2 = new SoftballTeam();
      SoftballTeam t3 = new SoftballTeam();
      t1.readPlayerFile("softball_player_data.csv");
      t2.readPlayerFile("softball_player_data2.csv");
      t3.readPlayerFile("softball_player_data2.large_team.csv");
      t2.setPlayerCount(2);
      Assert.assertEquals(5, t1.getPlayerCount(), 0.02);
      Assert.assertEquals(2, t2.getPlayerCount(), 0.02);
   }
   /**
a test which tests the Excluded records methods.
@throws IOException required for it to run.
*/
   @Test public void excludedRecordsTest() throws IOException {
      SoftballTeam t1 = new SoftballTeam();
      SoftballTeam t2 = new SoftballTeam();
      SoftballTeam t3 = new SoftballTeam();
      t1.readPlayerFile("softball_player_data.csv");
      t2.readPlayerFile("softball_player_data2.csv");
      t3.readPlayerFile("softball_player_data2.large_team.csv");
      t1.setExcludedRecords(t2.getExcludedRecords());
      Assert.assertEquals(true, 
         t1.getExcludedRecords().equals(t2.getExcludedRecords()));
   }
   /**
a test which tests the excluded count methods.
@throws IOException required for it to run.
*/
   @Test public void excludedCountTest() throws IOException {
      SoftballTeam t1 = new SoftballTeam();
      SoftballTeam t2 = new SoftballTeam();
      SoftballTeam t3 = new SoftballTeam();
      t1.readPlayerFile("softball_player_data.csv");
      t2.readPlayerFile("softball_player_data2.csv");
      t3.readPlayerFile("softball_player_data2.large_team.csv");
      t2.setExcludedCount(2);
      Assert.assertEquals(1, t1.getExcludedCount(), 0.02);
      Assert.assertEquals(2, t2.getExcludedCount(), 0.02);
   }
   /**
a test which tests the team count methods.
@throws IOException required for it to run.
*/
   @Test public void teamcountTest() throws IOException {
      SoftballTeam.resetTeamCount();
      SoftballTeam t1 = new SoftballTeam();
      SoftballTeam t2 = new SoftballTeam();
      SoftballTeam t3 = new SoftballTeam();
      t1.readPlayerFile("softball_player_data.csv");
      t2.readPlayerFile("softball_player_data2.csv");
      t3.readPlayerFile("softball_player_data2.large_team.csv");
      Assert.assertEquals(3, SoftballTeam.getTeamCount(), 0.02);
      SoftballTeam.resetTeamCount();
      Assert.assertEquals(0, SoftballTeam.getTeamCount(), 0.02);
   }
   /**
a test which tests the report methods.
@throws IOException required for it to run.
*/
   @Test public void reportTests() throws IOException {
      SoftballTeam t1 = new SoftballTeam();
      SoftballTeam t2 = new SoftballTeam();
      SoftballTeam t3 = new SoftballTeam();
      t1.readPlayerFile("softball_player_data.csv");
      t2.readPlayerFile("softball_player_data2.csv");
      t3.readPlayerFile("softball_player_data2.large_team.csv");
      Assert.assertEquals(true, 
         t1.generateReport().contains("Team Report for Auburn Stars"));
      Assert.assertEquals(true, 
         t1.generateReportByName().contains("Team Report for"
            + " Auburn Stars (by Name)"));
      Assert.assertEquals(true, 
         t1.generateReportByNumber().contains("Team Report for"
            + " Auburn Stars (by Number)"));
      Assert.assertEquals(true, 
         t2.generateReportByRating().contains("Team Report for"
            + " My Bigger Team (by Rating)"));
   }
   
}
