package top.takuron.ncpuy.tools.utils

object TerminalUtils {

    const val DEFAULT_MENU_TITLE = "Select an option"
    const val DEFAULT_MENU_SELECT = "Input the option you select:"

    const val ERROR_INPUT = "Incorrect input!!"

    fun buildMenu(list:List<String>,action:(pos:Int) -> Unit,title:String = DEFAULT_MENU_TITLE){
        while(true){
            println("--------------------")
            println(title)

            val it = list.iterator()
            var pos = 1
            while(it.hasNext()){
                println("${pos}:${it.next()}")
                pos += 1
            }

            println("\ne:exit")
            println("--------------------")
            print(DEFAULT_MENU_SELECT)


            var input = readln()

            if(input.toIntOrNull()!=null){
                val num = input.toInt()-1
                if(num<list.size) action(num)
                else  println(ERROR_INPUT)
            }
            else{
                if(input=="e") break
                else println(ERROR_INPUT)
            }
        }
    }
}