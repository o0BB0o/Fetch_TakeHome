package com.example.yifan_fetch_th.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.yifan_fetch_th.database.Candidates
import com.example.yifan_fetch_th.database.HiringBuilder
import org.json.JSONArray

class MainViewModel(application: Application) : AndroidViewModel(application) {
    init {
        HiringBuilder.initialize(application)
        parseJson()
    }

    private val builder = HiringBuilder.get()
    private var dataURL: String = "https://fetch-hiring.s3.amazonaws.com/hiring.json"

    /* Parse Json file using the URL above.
    TODO Could add a header checker and check the Last-Modified time and decide whether call parse or not.
     */
    fun parseJson() {
        val queue = Volley.newRequestQueue(getApplication())
        val stringRequest = StringRequest(
            Request.Method.GET, dataURL,
            { response ->
                val jsonArray = JSONArray(response.toString())
                for(i in 0 until jsonArray.length()){
                    val currTuple = jsonArray.getJSONObject(i)
                    val newCandidate = Candidates(currTuple.getInt("id"),
                        currTuple.getInt("listId"), currTuple.getString("name"))
                    builder.insert(newCandidate)
                }
            },
            { Log.e("Error", "Retrieve JSON FAILED!!") })
        queue.add(stringRequest)
    }

    fun parseOutput(targetListId: Int): LiveData<List<Candidates>> {
        val temp: LiveData<List<Candidates>>
        when (targetListId) {
            1 -> temp = HiringBuilder.get().showList1()
            2 -> temp = HiringBuilder.get().showList2()
            3 -> temp = HiringBuilder.get().showList3()
            4 -> temp = HiringBuilder.get().showList4()
            else -> temp = HiringBuilder.get().showResults()
        }
        return temp
    }
}