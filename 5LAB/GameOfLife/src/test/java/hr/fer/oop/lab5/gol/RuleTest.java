package hr.fer.oop.lab5.gol;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;

public class RuleTest {

	// Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
	@Test
	public void aliveCellWithLessThenTwoNeighbours_should_die() {
		boolean alive = true;

		assertThat(Rule.futureOf(alive, 1), is(false));
		assertThat(Rule.futureOf(alive, 0), is(false));
	}
	

	// Any live cell with two or three live neighbours lives on to the next generation.
	@Test
	public void aliveCellWith2Or3Neighbours_should_live() {
		boolean alive = true;

		assertThat(Rule.futureOf(alive, 2), is(true));
		assertThat(Rule.futureOf(alive, 3), is(true));
	}
	
	// Any live cell with more than three live neighbours dies, as if by overpopulation.
	@Test
	public void aliveCellWithMoneThen3Neighbours_should_die() {
		boolean alive = true;
		
		assertThat(Rule.futureOf(alive, 4), is(false));
		assertThat(Rule.futureOf(alive, 5), is(false));
		assertThat(Rule.futureOf(alive, 6), is(false));
		assertThat(Rule.futureOf(alive, 7), is(false));
		assertThat(Rule.futureOf(alive, 8), is(false));
	}
	
	
	// Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
	@Test
	public void deadCellWith3Neighbours_should_becomeLive() {
		boolean alive = false;
		
		assertThat(Rule.futureOf(alive, 3), is(true));
	}

	// Any dead cell not exactly three live neighbours stays dead.
	@Test
	public void deadCellWithOtherThen3Neighbours_should_beDead() {
		boolean alive = false;
		
		assertThat(Rule.futureOf(alive, 0), is(false));
		assertThat(Rule.futureOf(alive, 1), is(false));
		assertThat(Rule.futureOf(alive, 2), is(false));
		assertThat(Rule.futureOf(alive, 4), is(false));
		assertThat(Rule.futureOf(alive, 5), is(false));
		assertThat(Rule.futureOf(alive, 6), is(false));
		assertThat(Rule.futureOf(alive, 7), is(false));
		assertThat(Rule.futureOf(alive, 8), is(false));
	}
}
