import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.test2.ItemWithCounters
import com.example.test2.Register

class RegisterViewModel : ViewModel() {


    val registerList = mutableStateListOf<Register>()
    val shuffledList = mutableStateListOf<Register>()
    val properties1=mutableStateListOf<ItemWithCounters>()
    val properties2=mutableStateListOf<ItemWithCounters>()
    val properties3=mutableStateListOf<ItemWithCounters>()
    val properties4=mutableStateListOf<ItemWithCounters>()
    val properties5=mutableStateListOf<ItemWithCounters>()
    val properties6=mutableStateListOf<ItemWithCounters>()
    val properties7=mutableStateListOf<ItemWithCounters>()
    val properties8=mutableStateListOf<ItemWithCounters>()




    fun addRegister(name: String, money: Int = 0) {
        if (name.isNotBlank() && registerList.size < 8) {
            val newPlayer = Register(
                Name = name,
                MoneyValue = money,

            )

            registerList.add(newPlayer)
            shuffledList.clear()
            shuffledList.addAll(registerList)
        }
    }



    fun removeRegister(name: String) {
        registerList.removeAll { it.Name == name }
        shuffledList.removeAll { it.Name == name }
    }

    fun shuffleNames() {
        shuffledList.clear()
        shuffledList.addAll(registerList.shuffled())
    }
    fun getMoney(name: String, newMoney: Int):Int {
        val register = registerList.find { it.Name == name }
        register?.Money?.value = newMoney
        return newMoney
    }


    fun updateMoney(name: String, newMoney: Int) {
        val register = registerList.find { it.Name == name }
        register?.Money?.value = newMoney
    }


}

