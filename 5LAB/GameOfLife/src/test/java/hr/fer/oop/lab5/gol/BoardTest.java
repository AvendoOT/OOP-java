package hr.fer.oop.lab5.gol;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

public class BoardTest {

	private Board board;

	private void assertThatCellIsNotAlive(int x, int y) {
		assertThat("cell[" + x + "][" + y + "]", board.isCellAlive(x,y), is(false));
	}
	
	private void assertThatCellIsAlive(int x, int y) {
		assertThat("cell[" + x + "][" + y + "]", board.isCellAlive(x,y), is(true));
	}
	
	@Test
	public void boardWithOneCell_should_haveSizeOne() throws Exception {
		board = new Board(1,1);
		assertThat(board.getWidth(), is(1));
		assertThat(board.getHeight(), is(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void boardWithZeroWidth_should_throwException() {
		board = new Board(0,1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void boardWithNegativeWidth_should_throwException() {
		board = new Board(-1,1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void boardWithZeroHeight_should_throwException() {
		board = new Board(1,0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void boardWithNegativeHeight_should_throwException() {
		board = new Board(1,-1);
	}
	
	@Test
	public void boardWithOneCell_should_beInitializedToFalse() {
		board = new Board(1,1);
		int y = 0;
		int x = y;
		assertThatCellIsNotAlive(y, x);
	}

	@Test
	public void boardWithOneRow_should_haveAllCellsToFalse() throws Exception {
		board = new Board(10,1);
		assertThat(board.getWidth(), is(10));
		
		for(int i = 0; i < board.getWidth(); i++) {
			assertThatCellIsNotAlive(i,0);
		}
	}
	
	@Test
	public void boardWithOneColumn_should_haveAllCellsToFalse() throws Exception {
		board = new Board(1,10);
		assertThat(board.getHeight(), is(10));
		
		for(int i = 0; i < board.getWidth(); i++) {
			assertThatCellIsNotAlive(0,i);
		}
	}

	@Test
	public void boardWith4Cells_should_haveAllCellsToFalse() throws Exception {
		board = new Board(2,2);
		assertThat(board.getHeight(), is(2));
		assertThat(board.getWidth(), is(2));
		
		for(int x = 0; x < board.getWidth(); x++) {
			for(int y = 0; y < board.getHeight(); y++) {
				assertThatCellIsNotAlive(x,y);
			}
		}
	}
	
	@Test
	public void boardSettingOneCell_should_thatCellToTrueAndOthersToFalse() throws Exception {
		board = new Board(10,10);
		int xSet = 3, ySet=5;
		
		board.setCell(xSet, ySet, true);
		
		for(int x = 0; x < board.getWidth(); x++) {
			for(int y = 0; y < board.getHeight(); y++) {
				if(x == xSet && y == ySet) {
					assertThatCellIsAlive(x,y);					
				} else {
					assertThatCellIsNotAlive(x,y);
				}
			}
		}
	}
	
	@Test
	public void toString_should_returnBoardRepresentation() throws Exception {
		board = new Board(5,5);
		board.setCell(1, 1, true);
		board.setCell(2, 1, true);
		
		assertThat(board.toString(), is(
				"-----\n" + // row 0
				"-oo--\n" + // row 1
				"-----\n" + // row 2 
				"-----\n" + // row 3
				"-----\n")); // row 4
	}
	
	@Test
	public void negativeCoordinates_should_NormalizedAndReturnValue() throws Exception {
		board = new Board(5,10);
		
		board.setCell(-1, -1, true);
		
		assertThatCellIsAlive(-1,-1);
		assertThatCellIsAlive(5-1, 10-1);
	}
	
	@Test
	public void overMaxCoordinates_should_NormalizedAndReturnValue() throws Exception {
		board = new Board(5,10);
		
		board.setCell(6, 11, true);
		
		assertThatCellIsAlive(6,11);
		assertThatCellIsAlive(1, 1);
	}
	
	
	@Test
	public void settingBoardWithString_should_setValuesCorrect() throws Exception {
		board = new Board(3,3, 
				  "-o-"
				+ "o--"
				+ "-o-");
		
		assertThat(board.toString(), is(""
				+ "-o-\n"
				+ "o--\n"
				+ "-o-\n"));
	}
	
	@Test
	public void countingNeighbors_should_returnNumberOfAliveNeighbors() throws Exception {
		board = new Board(3,3, 
				  "ooo"
				+ "o-o"
				+ "---");

		assertThat(board.countAliveNeighbors(0,0), is(4));
		assertThat(board.countAliveNeighbors(1,0), is(4));
		assertThat(board.countAliveNeighbors(1,1), is(5));
		assertThat(board.countAliveNeighbors(1,2), is(5));
	}
	
	@Test
	public void blinker_should_BlinkInTwoPeriods() throws Exception {
		board = new Board(5,5, "" 
				+ "-----"
				+ "--o--"
				+ "--o--"
				+ "--o--"
				+ "-----");
		
		board.playOneIteration();
		
		assertThat(board.toString(), is(""
				+ "-----\n"
				+ "-----\n"
				+ "-ooo-\n"
				+ "-----\n"
				+ "-----\n"
				));
		
		board.playOneIteration();

		assertThat(board.toString(), is(""
				+ "-----\n"
				+ "--o--\n"
				+ "--o--\n"
				+ "--o--\n"
				+ "-----\n"
				));
	}

	@Test
	public void toad_should_BlinkInTwoPeriods() throws Exception {
		board = new Board(6,6, "" 
				+ "------"
				+ "------"
				+ "--ooo-"
				+ "-ooo--"
				+ "------"
				+ "------"
				);
		
		board.playOneIteration();
		
		assertThat(board.toString(), is(""
				+ "------\n"
				+ "---o--\n"
				+ "-o--o-\n"
				+ "-o--o-\n"
				+ "--o---\n"
				+ "------\n"
				));
		
		board.playOneIteration();

		assertThat(board.toString(), is(""
				+ "------\n"
				+ "------\n"
				+ "--ooo-\n"
				+ "-ooo--\n"
				+ "------\n"
				+ "------\n"
				));
	}
	
	@Test
	public void registeredListener_should_beCalledAfterOneInteration() throws Exception {
		BoardListener listener = Mockito.mock(BoardListener.class);
		board = new Board(5,5);
		
		board.addListener(listener);
		
		board.playOneIteration();
		
		verify(listener).boardChanged(board);
	}

	@Test
	public void registered2Listeners_should_beCalledAfterOneInterationOnEachListener() throws Exception {
		BoardListener listener1 = Mockito.mock(BoardListener.class);
		BoardListener listener2 = Mockito.mock(BoardListener.class);
		board = new Board(5,5);
		
		board.addListener(listener1);
		board.addListener(listener2);
		
		board.playOneIteration();
		
		verify(listener1).boardChanged(board);
		verify(listener2).boardChanged(board);
	}
	
	@Test
	public void removingRegisteredListener_should_notCallMethodInListener() throws Exception {
		BoardListener listener = Mockito.mock(BoardListener.class);
		board = new Board(5,5);
		
		board.addListener(listener);
		board.removeListener(listener);
		
		board.playOneIteration();
		
		verify(listener, never()).boardChanged(board);
	}

}
