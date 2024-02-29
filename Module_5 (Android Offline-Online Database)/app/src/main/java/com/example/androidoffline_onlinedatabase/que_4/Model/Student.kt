
import com.google.gson.annotations.SerializedName

data class Student(
    var id : String,
    var name : String,
    var email : String,
    @SerializedName("mobile")
    var contact : String
)
