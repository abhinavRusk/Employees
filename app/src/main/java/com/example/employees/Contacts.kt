package com.example.employees

import com.google.gson.annotations.SerializedName

class Contacts (
    @SerializedName("data") val contacts: ArrayList<ContactsItem>
    )

