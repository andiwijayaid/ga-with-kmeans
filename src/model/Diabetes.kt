package model

class Diabetes(var id: Int, var pregnancies: Int, var glucose: Int, var age: Int, var blood_pressure: Int) {

    override fun toString(): String {
        return "Diabetes [id=" + id + ", pregnancies=" + pregnancies + ", glucose=" + glucose + ", age=" + age + ", blood_presure=" + blood_pressure + "]"
    }

}