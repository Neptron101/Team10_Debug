/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author PC
 */
public class MainTest {
    @Test
    public void testMain(){
        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Game game = new Game(d1, d2, d3);
        
        int balance = 100;
        int limit = 5;
        int amount = 50;
        List<DiceValue> dV = game.getDiceValues();
        
        Player player = new Player("Bikin", balance);
        

        

        player.setLimit(limit);
        
        System.out.println(String.format("%s starts with balance %d, limit %d", 
                		player.getName(), player.getBalance(), player.getLimit()));
         System.out.println("-------------------------");
        //Test the following method from Player class
        boolean exc1 = player.balanceExceedsLimit();
        boolean exc2 = player.balanceExceedsLimitBy(amount);
        //True if the balance Exceeds Limit i.e. 100>10
        assertTrue(exc1);
        //True if (balance-amount) >= limit i.e. 100-50>10
        assertTrue(exc2);
        
        //When anchor is rolled
        System.out.println("Anchor rolled");
        
        for (int i = 0; i<5 ; i++){
            DiceValue pick1 = DiceValue.ANCHOR;
           
            int win = game.playRound(player, pick1, limit);
            //asserEquals for rolling the anchor in none, one, two and three dice
            switch (win) {
                case 0:
                    assertEquals(0,win);
                    System.out.println("Anchor didnot occur in all the three dice in 1 roll");
                    break;
                case 5:
                    assertEquals(5,win);
                    System.out.println("Anchor occured once among the three dice in 1 roll");
                    break;
                case 10:
                    assertEquals(10,win);
                    System.out.println("Anchor occured twice among the three dice in 1 roll");
                    break;
                case 15:
                    assertEquals(15,win);
                    System.out.println("Anchor occured thrice among the three dice in 1 roll");
                    break;
                default:
                    break;
            }
            System.out.println("Won = " + win + " Balance now = " + player.getBalance());
            
        }
        
        System.out.println("-------------------------");
        //When Heart is rolled
        System.out.println("Heart rolled");
        
        for (int i = 0; i<5 ; i++){
            DiceValue pick2 = DiceValue.HEART;
            
            int win = game.playRound(player, pick2, limit);
            //asserEquals for rolling the heart in none, one, two and three dice
            switch (win) {
                case 0:
                    assertEquals(0,win);
                    System.out.println("Heart didnot occur in all the three dice in 1 roll");
                    break;
                case 5:
                    assertEquals(5,win);
                    System.out.println("Heart occured once among the three dice in 1 roll");
                    break;
                case 10:
                    assertEquals(10,win);
                    System.out.println("Heart occured twice among the three dice in 1 roll");
                    break;
                case 15:
                    assertEquals(15,win);
                    System.out.println("Heart occured thrice among the three dice in 1 roll");
                    break;
                default:
                    break;
            }

            System.out.println("Won = " + win + " Balance now = " + player.getBalance());
        }
    }   
}
    