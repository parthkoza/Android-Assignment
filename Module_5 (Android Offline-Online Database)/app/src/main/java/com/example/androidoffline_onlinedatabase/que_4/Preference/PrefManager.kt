
import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

class PrefManager(context: Context) {

    private val PREF_NAME = "com.example.apicalling"
    private val KEY_LOGIN = "login"


    private var preferences: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    private val editor: Editor = preferences.edit()

    fun updateLoginStatus(status: Boolean) {
        editor.putBoolean(KEY_LOGIN, status)
        editor.commit()
    }

    fun getLoginStatus(): Boolean {
        return preferences.getBoolean(KEY_LOGIN, false)
    }
}