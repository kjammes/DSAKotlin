package arraysQuestions

fun main(args: Array<String>) {
    val arr1 = intArrayOf(1,5,9,12)
    val arr2 = intArrayOf(2,5,10,12,13,43)

    val result = mergeSortedArrays(arr1, arr2)
    println(result.contentToString())
}

fun mergeSortedArrays(arr1: IntArray, arr2: IntArray): IntArray {
    val mergedArray = IntArray(arr1.size + arr2.size)

    var pointerOne = 0;
    var pointerTwo = 0;

    var mergePointer = 0;
    while (pointerOne < arr1.size && pointerTwo < arr2.size) {
        val valOne = arr1[pointerOne++];
        val valTwo = arr2[pointerTwo++];

        if(valOne < valTwo) {
            mergedArray[mergePointer++] = valOne;
            mergedArray[mergePointer++] = valTwo;
        } else {
            mergedArray[mergePointer++] = valTwo;
            mergedArray[mergePointer++] = valOne;
        }
    }

    while (pointerOne < arr1.size) {
        mergedArray[mergePointer++] = arr1[pointerOne++];
    }

    while(pointerTwo < arr2.size) {
        mergedArray[mergePointer++] = arr2[pointerTwo++];
    }

    return mergedArray
}