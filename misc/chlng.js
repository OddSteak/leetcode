function accumulate(combiner, nullValue, l) {
    if (l.length == 0)
        return nullValue;
    var first = l.shift();
    return combiner(first, accumulate(combiner, nullValue, l));
}

/**
 * Implement sumOfSquares, which calculates the sum of squares of a list,
 * for example

 * sumOfSquares([1,2,3,4,5])
 */

console.log(accumulate((a, fn) => a*a + fn, 0, [1, 2, 3, 4, 5]))
