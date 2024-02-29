
import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    var status :String,
    var message : String,
    @SerializedName("student")
    var student : MutableList<Student>,
)
