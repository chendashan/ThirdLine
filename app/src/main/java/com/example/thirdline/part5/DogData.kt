package com.example.thirdline.part5

import android.os.Parcel
import android.os.Parcelable

class DogData(val number: Int, val name: String, val type: String) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(number)
        parcel.writeString(name)
        parcel.writeString(type)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DogData> {
        override fun createFromParcel(parcel: Parcel): DogData {
            return DogData(parcel)
        }

        override fun newArray(size: Int): Array<DogData?> {
            return arrayOfNulls(size)
        }
    }
}