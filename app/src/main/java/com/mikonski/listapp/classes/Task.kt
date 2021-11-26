package com.mikonski.listapp.classes

import android.os.Parcel
import android.os.Parcelable

class Task(val name: String, val tasks: ArrayList<String> = ArrayList()): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.createStringArrayList()!!

    )

    override fun describeContents() =0

    override fun writeToParcel(dest: Parcel, flags: Int) {
       dest.writeString(name)
        dest.writeStringList(tasks)
    }

    companion object CREATOR : Parcelable.Creator<Task> {
        override fun createFromParcel(parcel: Parcel): Task {
            return Task(parcel)
        }

        override fun newArray(size: Int): Array<Task?> {
            return arrayOfNulls(size)
        }
    }

}