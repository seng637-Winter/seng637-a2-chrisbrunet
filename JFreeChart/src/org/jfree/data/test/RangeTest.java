package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;

import org.junit.*;

public class RangeTest {
    private Range posPosRange;
    private Range zeroPosRange;
    private Range negZeroRange;
    private Range negNegRange;
    private Range negPosRange;
    private Range zeroLengthRange;
    private Range infInfRange;
    
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 
    	posPosRange = new Range(10, 21);
    	zeroPosRange = new Range(0,20);
    	negZeroRange = new Range(-20,0);
    	negNegRange = new Range(-20,-10);
    	negPosRange = new Range(-20,20);
    	zeroLengthRange = new Range(0,0);
    	infInfRange = new Range(Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);
    }
    
    // getLowerBound() TESTS
    
    // #1
    @Test
    public void getLowerBoundPosPosRange() {
        assertEquals("The lower bound of Range(10,20) should be 10",
        10, posPosRange.getLowerBound(), .000000001d);
    }
    
    // #2
    @Test
    public void getLowerBoundZeroPosRange() {
        assertEquals("The lower bound of Range(0,20) should be 0",
        0, zeroPosRange.getLowerBound(), .000000001d);
    }
    
    // #3
    @Test
    public void getLowerBoundNegZeroRange() {
        assertEquals("The lower bound of Range(-20,0) should be -20",
        -20, negZeroRange.getLowerBound(), .000000001d);
    }
    
    // #4
    @Test
    public void getLowerBoundNegNegRange() {
       assertEquals("The lower bound of Range(-20,-10) should be -20",
       -20, negNegRange.getLowerBound(), .000000001d);
    }
    
    // #5
    @Test
    public void getLowerBoundNegPosRange() {
        assertEquals("The lower bound of Range(-20,20) should be -20",
        -20, negPosRange.getLowerBound(), .000000001d);
    }
    
    // #6
    @Test
    public void getLowerBoundZeroLengthRange() {
        assertEquals("The lower bound of Range(0,0) should be 0",
        0, zeroLengthRange.getLowerBound(), .000000001d);
    }
    
    // #7
    @Test
    public void getLowerBoundInfInfRange() {
        assertEquals("The lower bound of Range(-inf,+inf) should be -inf",
        Double.NEGATIVE_INFINITY, infInfRange.getLowerBound(), .000000001d);
    }
    
    // getUpperBound() TESTS
    
    // #1
    @Test
    public void getUpperBoundPosPosRange() {
        assertEquals("The upper bound of Range(10,20) should be 20",
        20, posPosRange.getUpperBound(), .000000001d);
    }
    
    // #2
    @Test
    public void getUpperBoundZeroPosRange() {
        assertEquals("The upper bound of Range(0,20) should be 20",
        20, zeroPosRange.getUpperBound(), .000000001d);
    }
    
    // #3
    @Test
    public void getUpperBoundNegZeroRange() {
        assertEquals("The upper bound of Range(-20,0) should be 0",
        0, negZeroRange.getUpperBound(), .000000001d);
    }
    
    // #4
    @Test
    public void getUpperBoundNegNegRange() {
       assertEquals("The upper bound of Range(-20,-10) should be -10",
       -10, negNegRange.getUpperBound(), .000000001d);
    }
    
    // #5
    @Test
    public void getUpperBoundNegPosRange() {
        assertEquals("The upper bound of Range(-20,20) should be 20",
        20, negPosRange.getUpperBound(), .000000001d);
    }
    
    // #6 
    @Test
    public void getUpperBoundZeroLengthRange() {
        assertEquals("The upper bound of Range(0,0) should be 0",
        0, zeroLengthRange.getUpperBound(), .000000001d);
    }
    
    // #7
    @Test
    public void getUpperBoundInfInfRange() {
        assertEquals("The upper bound of Range(-inf,+inf) should be +inf",
        Double.POSITIVE_INFINITY, infInfRange.getUpperBound(), .000000001d);
    }
    
    // getLength() TESTS
 
    // #1
    @Test
    public void getLengthPosPosRange() {
        assertEquals("The length of Range(10,20) should be 10",
        10, posPosRange.getLength(), .000000001d);
    }
    
    // #2
    @Test
    public void getLengthZeroPosRange() {
        assertEquals("The upper bound of Range(0,20) should be 20",
        20, zeroPosRange.getLength(), .000000001d);
    }
    
    // #3
    @Test
    public void getLengthNegZeroRange() {
        assertEquals("The length of Range(-20,0) should be 20",
        20, negZeroRange.getLength(), .000000001d);
    }
    
    // #4
    @Test
    public void getLengthNegNegRange() {
       assertEquals("The length of Range(-20,-10) should be 10",
       10, negNegRange.getLength(), .000000001d);
    }
    
    // #5
    @Test
    public void getLengthNegPosRange() {
        assertEquals("The length of Range(-20,20) should be 40",
        40, negPosRange.getLength(), .000000001d);
    }
    
    // #6
    @Test
    public void getLengthZeroLengthRange() {
        assertEquals("The length of Range(0,0) should be 0",
        0, zeroLengthRange.getLength(), .000000001d);
    }
    
    // #7
    @Test
    public void getLengthInfInfRange() {
        assertEquals("The length of Range(-inf,+inf) should be +inf",
        Double.POSITIVE_INFINITY, infInfRange.getLength(), .000000001d);
    }
    
    // getCentralValue() TESTS
    
    // #1
    @Test
    public void getCentralValuePosPosEvenRange() {
        assertEquals("The median of Range(10,20) should be 15",
        15, posPosRange.getCentralValue(), .000000001d);
    }
    
    // #2
    @Test
    public void getCentralValueZeroPosRange() {
        assertEquals("The median of Range(0,20) should be 10",
        10, zeroPosRange.getCentralValue(), .000000001d);
    }
    
    // #3
    @Test
    public void getCentralValueNegZeroRange() {
        assertEquals("The median of Range(-20,0) should be -10",
        -10, negZeroRange.getCentralValue(), .000000001d);
    }
    
    // #4
    @Test
    public void getCentralValueNegNegRange() {
       assertEquals("The median of Range(-20,-10) should be -15",
       -15, negNegRange.getCentralValue(), .000000001d);
    }
    
    // #5
    @Test
    public void getCentralValueNegPosRange() {
        assertEquals("The median of Range(-20,20) should be 0",
        0, negPosRange.getCentralValue(), .000000001d);
    }
    
    // #6
    @Test
    public void getCentralValueZeroLengthRange() {
        assertEquals("The median of Range(0,0) should be 0",
        0, zeroLengthRange.getCentralValue(), .000000001d);
    }
    
    // #7
    @Test
    public void getCentralValueInfInfRange() {
        assertEquals("The median of Range(-inf,+inf) should be NaN",
        Double.NaN, infInfRange.getCentralValue(), .000000001d);
    }
    
    // #8
    @Test
    public void getCentralValuePosPosOddRange() {
    	assertEquals("The median of Range(10,21) should be 15.5",
        15.5, new Range(10, 21).getCentralValue(), .000000001d);
    }
    
    // #9
    @Test
    public void getCentralValueNegNegOddRange() {
    	assertEquals("The median of Range(-21,-10) should be -15.5",
        -15.5, new Range(-21, -10).getCentralValue(), .000000001d);
    }
    
    // constrain(double value) TESTS
    
    // #1
    @Test
    public void constrainEC1ShouldBeLowerPosPosRange() {
        assertEquals("The constrained value of 5 on Range(10,20) should be 10",
        10, posPosRange.constrain(5.0), .000000001d);
    }
    
    // #2
    @Test
    public void constrainEC2ShouldBeValuePosPosRange() {
        assertEquals("The constrained value of 15 on Range(10,20) should be 15",
        15, posPosRange.constrain(15.0), .000000001d);
    }
    
    // #3
    @Test
    public void constrainEC3ShouldBeUpperPosPosRange() {
        assertEquals("The constrained value of 25 on Range(10,20) should be 20",
        20, posPosRange.constrain(25.0), .000000001d);
    }
    
    // #4
    @Test
    public void constrainLBShouldBeValuePosPosRange() {
        assertEquals("The constrained value of 10 on Range(10,20) should be 10",
        10, posPosRange.constrain(10.0), .000000001d);
    }
    
    // #5
    @Test
    public void constrainALBShouldBeValuePosPosRange() {
        assertEquals("The constrained value of 10.1 on Range(10,20) should be 10.1",
        10.1, posPosRange.constrain(10.1), .000000001d);
    }
    
    // #6
    @Test
    public void constrainBUBShouldBeValuePosPosRange() {
        assertEquals("The constrained value of 19.9 on Range(10,20) should be 19.9",
        19.9, posPosRange.constrain(19.9), .000000001d);
    }
    
    // #7
    @Test
    public void constrainUBShouldBeValuePosPosRange() {
        assertEquals("The constrained value of 20 on Range(10,20) should be 20",
        20, posPosRange.constrain(20.0), .000000001d);
    }
    
    // #8
    @Test
    public void constrainBLBShouldBeLowerPosPosRange() {
        assertEquals("The constrained value of 9.9 on Range(10,20) should be 10",
        10, posPosRange.constrain(9.9), .000000001d);
    }
    
    // #9
    @Test
    public void constrainAUBShouldBeUpperPosPosRange() {
        assertEquals("The constrained value of 20.1 on Range(10,20) should be 20",
        20, posPosRange.constrain(20.1), .000000001d);
    }
    
    // #10
    @Test
    public void constrainEC1ShouldBeLowerNegNegRange() {
        assertEquals("The constrained value of -25 on Range(-20,-10) should be -20",
        -20, negNegRange.constrain(-25.0), .000000001d);
    }
    
    // #11
    @Test
    public void constrainEC2ShouldBeValueNegNegRange() {
        assertEquals("The constrained value of -15 on Range(-20,-10) should be -15",
        -15, negNegRange.constrain(-15.0), .000000001d);
    }
    
    // #12
    @Test
    public void constrainEC3ShouldBeUpperNegNegRange() {
        assertEquals("The constrained value of -5 on Range(-20,-10) should be -10",
        -10, posPosRange.constrain(-5), .000000001d);
    }
    
    // #13
    @Test
    public void constrainLBShouldBeValueNegNegRange() {
        assertEquals("The constrained value of -20 on Range(-20,-10) should be -20",
        -20, negNegRange.constrain(-20.0), .000000001d);
    }
    
    // #14
    @Test
    public void constrainALBShouldBeValueNegNegRange() {
        assertEquals("The constrained value of -19.9 on Range(-20,-10) should be -19.9",
        -19.9, negNegRange.constrain(-19.9), .000000001d);
    }
    
    // #15
    @Test
    public void constrainBUBShouldBeValueNegNegRange() {
        assertEquals("The constrained value of -10.1 on Range(-20,-10) should be -10.1",
        -10.1, posPosRange.constrain(-10.1), .000000001d);
    }
    
    // #16
    @Test
    public void constrainUBShouldBeValueNegNegRange() {
        assertEquals("The constrained value of 20 on Range(-20,-10) should be -10",
        -10, posPosRange.constrain(-10.0), .000000001d);
    }
    
    // #17
    @Test
    public void constrainBLBShouldBeLowerNegNegRange() {
        assertEquals("The constrained value of -20.1 on Range(-20,-10) should be -20",
        -20, posPosRange.constrain(-20.1), .000000001d);
    }
    
    // #18
    @Test
    public void constrainAUBShouldBeUpperNegNegRange() {
        assertEquals("The constrained value of -9.9 on Range(-20,-10) should be -10",
        -10, posPosRange.constrain(-9.9), .000000001d);
    }
    
    // #19
    @Test
    public void constrainEC2ShouldBeValueNegPosRange() {
        assertEquals("The constrained value of 0 on Range(-20,20) should be 0",
        0, posPosRange.constrain(0), .000000001d);
    }
    
    // CONSTRAIN SPECIAL CASES
    
    // #20
    @Test
    public void constrainPositiveInfinityShouldBeUpper() {
        assertEquals("The constrained value of +inf on Range(-20,20)) should be 20",
        20, negPosRange.constrain(Double.POSITIVE_INFINITY), .000000001d);
    }
    
    // #21
    @Test
    public void constrainNegativeInfinityShouldBeLower() {
        assertEquals("The constrained value of -inf on Range(-20,20) should be -20",
        -20, negPosRange.constrain(Double.NEGATIVE_INFINITY), .000000001d);
    }
    
    // #22
    @Test
    public void constrainEC1ZeroLengthRangeShouldBeUpperAndLower() {
        assertEquals("The constrained value of 5 on Range(0,0) should be 0",
        0, zeroLengthRange.constrain(5), .000000001d);
    }
    
    // #22
    @Test
    public void constrainEC2ZeroLengthRangeShouldBeUpperAndLower() {
        assertEquals("The constrained value of -5 on Range(0,0) should be 0",
        0, zeroLengthRange.constrain(-5), .000000001d);
    }
    
    // #22
    @Test
    public void constrainEC3ZeroLengthRangeShouldBeUpperAndLower() {
        assertEquals("The constrained value of 0 on Range(0,0) should be 0",
        0, zeroLengthRange.constrain(0), .000000001d);
    }
   

    @After
    public void tearDown() throws Exception {
    	posPosRange = null;
    	zeroPosRange = null;
    	negZeroRange = null;
    	negNegRange = null;
    	negPosRange = null;
    	zeroLengthRange = null;
    	infInfRange = null;
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
