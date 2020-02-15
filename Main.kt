/*
* Алгроитм взял отсюда: https://habr.com/ru/post/428552/
*
* Краткая суть:
* 1.На вход должен быть подан отсортированный массив
* 2.Начиная с конца ищем первый элемент что больше следующего и запоминаем его номер (pivot)
* 3.Если такого элемента нет, то все перестановки найдены (именно для корректного выполнения этого условия массив должен быть сперва отсортирован во возрастанию) )
* 4.Сортируем суффикс (все элементы от pivot до конца массива)
* 5.Ищем ближайший по возрастанию элемент в суффиксе от элемента с номером pivot - 1
* 6.Меняем их местами
* 7.Еще раз отсортируем суффикс
* 8.Перестановка получена, она будет исходным массивом для следующей итерации
*
* */

fun main(args: Array<String>)
{
    var array: Array<Int> = arrayOf(3,2,1)
    var count: Int  = 1
    array.sort()//1.
    printArray(array)
    while (getPermutation(array))
    {
        count++

    }
    println("Количество перестановок равно $count")

}
fun getPermutation(array: Array<Int>): Boolean
{

    val n:Int = array.size
    var i: Int = n - 1
    var pivot: Int = 0
    var j: Int
    var temp: Int = 0
    for (i in n-1 downTo 0 )//2.
    {
        if(i==0)//3.
        {
            return false
        }
        if(array[i-1]<array[i])
        {
            pivot = i
            break
        }
    }
    j = pivot
    array.sort(j,n)//4.
    pivot = getMinInPartArray(array,pivot,j-1)//5.

    array[pivot] = array[j-1].also { array[j-1] = array[pivot] }//6.
    array.sort(j+1,n)//7.

    printArray(array)
    return true
}
fun printArray(array: Array<Int>)
{
    for (i in array)
    {
        print(i)
    }
    println()
}
fun getMinInPartArray(array: Array<Int>, start: Int, pivot: Int ): Int
{

    for (i in start..array.size)
    {
        if(array[i]>array[pivot])
        {
            return i
        }

    }
        return -1
}