package dev.matsujun.puppies.data

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

@Immutable
data class Puppy(
    val id: Int,
    val name: String,
    val imageUrl: String? = null,
    val birthDay: LocalDate,
    val ownerName: String,
) {
    fun birthDayText(): String = birthDay.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
    fun age(): Long = ChronoUnit.YEARS.between(birthDay, LocalDate.now())
}