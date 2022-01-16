package com.compititionapp.Util

import android.content.Context
import com.compititionapp.model.studymaterialAPI.GetStudyMaterial
import com.compititionapp.personlize.CustomObjectChoices
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.io.InputStream
import java.lang.reflect.Type
import kotlin.text.Charsets.UTF_8

class Utils {
    companion object {
        fun getJsonFromAssets(context: Context, fileName: String?): String? {
            val jsonString: String

            jsonString = try {
                val `is`: InputStream = context.assets.open(fileName!!)
                val size: Int = `is`.available()
                val buffer = ByteArray(size)
                `is`.read(buffer)
                `is`.close()
                String(buffer, UTF_8)
            } catch (e: IOException) {
                e.printStackTrace()
                return null
            }
            return jsonString
        }

        fun loadJsonFromLocal(context: Context?): CustomObjectChoices {
            val jsonFileString: String? = getJsonFromAssets(context!!, "personlise.json")
            //Log.i("data", jsonFileString)

            val gson = Gson()
            val listUserType: Type = object : TypeToken<CustomObjectChoices?>() {}.type

            val choices: CustomObjectChoices = gson.fromJson<CustomObjectChoices>(jsonFileString, listUserType)

            return choices

        }
        fun loadMathSubjectJson(context: Context): GetStudyMaterial {
            val jsonFileString: String? = getJsonFromAssets(context, "math_study_material")
            //Log.i("data", jsonFileString)

            val gson = Gson()
            val listUserType: Type = object : TypeToken<GetStudyMaterial?>() {}.type

            val addUser: GetStudyMaterial = gson.fromJson<GetStudyMaterial>(jsonFileString, listUserType)

            return addUser

        }
        fun loadSciSubjectJson(context: Context): GetStudyMaterial {
            val jsonFileString: String? = getJsonFromAssets(context, "sci_study_material")
            //Log.i("data", jsonFileString)

            val gson = Gson()
            val listUserType: Type = object : TypeToken<GetStudyMaterial?>() {}.type

            val addUser: GetStudyMaterial = gson.fromJson<GetStudyMaterial>(jsonFileString, listUserType)

            return addUser

        }
    }
}