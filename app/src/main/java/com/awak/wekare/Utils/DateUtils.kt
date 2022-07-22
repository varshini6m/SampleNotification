package com.awak.wekare.Utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.*
import java.time.format.DateTimeFormatter
import java.util.*


object DateUtils {
    val SUNDAY = 0
    val MONDAY = 1
    val TUESDAY = 2
    val WEDNESDAY = 3
    val THURSDAY = 4
    val FRIDAY = 5
    val SATURDAY = 6
    private const val APPOINTMENTS_DATE_FORMAT = "dd-MM-yyyy"
    private const val APPOINTMENTS_DATE_FORMAT_PATTERN = "dd-MM-uuuu"
    private const val APPOINTMENTS_BOOKED_DATE_FORMAT = "MMM d,yyyy"
    private const val APPOINTMENTS_BOOKED_TIME_FORMAT = "hh:mm a"

    fun dateConversion(date: String): String {
        val date1: Date = SimpleDateFormat("dd/MM/yyyy").parse(date)
        val formatter = SimpleDateFormat("EEE, dd MMM yyyy")
        return formatter.format(date1)
    }

    fun pastDateConversion(date: String): Date {
        val date1: Date = SimpleDateFormat("yyyy-MM-dd").parse(date)
        return date1
    }

    fun getDateBeforeSixMonth(): String {
        val format = SimpleDateFormat("yyyy-MM-dd")
        val cal = Calendar.getInstance()
        cal.add(Calendar.MONTH, -7)
        return format.format(cal.time)
    }

    fun getDateLastDate(): String {
        val format = SimpleDateFormat("yyyy-MM-dd")
        val cal = Calendar.getInstance()
        cal.add(Calendar.DATE, 0)
        return format.format(cal.time)
    }


    fun dateConversionTimeStampFromDate(date: String): String {
        val date1: Date = SimpleDateFormat("dd/MM/yyyy").parse(date)
        val calendar = Calendar.getInstance()
        calendar.time = date1
        val year = calendar[Calendar.YEAR]
        val month = calendar[Calendar.MONTH]
        val day = calendar[Calendar.DATE]
        calendar[year, month, day, 0, 0] = 0
        return calendar.time.time.toString()
    }

    fun dateConversionTimeStampFromDateString(date: String): String {
        val date1: Date = SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy").parse(date)
        val calendar = Calendar.getInstance()
        calendar.time = date1
        val year = calendar[Calendar.YEAR]
        val month = calendar[Calendar.MONTH]
        val day = calendar[Calendar.DATE]
        calendar[year, month, day, 0, 0] = 0
        return calendar.time.time.toString()
    }

    fun dateConversionTime(date: String): String {
        val date1: Date = SimpleDateFormat("dd/MM/yyyy").parse(date)
        val calendar = Calendar.getInstance()
        calendar.time = date1
        val year = calendar[Calendar.YEAR]
        val month = calendar[Calendar.MONTH]
        val day = calendar[Calendar.DATE]
        val calendar1 = Calendar.getInstance()
        calendar[year, month, day, calendar1.time.hours, calendar1.time.minutes] =
            calendar1.time.seconds
        return calendar.time.time.toString()
    }

    fun dateConversionTimeStampToDate(date: String): String {
        val date1: Date = SimpleDateFormat("dd/MM/yyyy").parse(date)
        val calendar = Calendar.getInstance()
        calendar.time = date1
        val year = calendar[Calendar.YEAR]
        val month = calendar[Calendar.MONTH]
        val day = calendar[Calendar.DATE]
        calendar[year, month, day, 23, 59] = 59
        return calendar.time.time.toString()
    }

    fun dateConversion(): String {
        val date1: Date = Calendar.getInstance().time
        val formatter = SimpleDateFormat("EEE, dd MMM yyyy")
        return formatter.format(date1)
    }


    fun getDateFromTimeStamp(timestamp: Long): String {
        val date1 = Date(timestamp)
        val formatter = SimpleDateFormat("EEE, dd MMM yyyy")
        return formatter.format(date1)

    }

    fun getDateFromTimeStampEMDY(timestamp: Long): String {
        val date1 = Date(timestamp)
        val formatter = SimpleDateFormat("EEE, MMM dd, yyyy")
        return formatter.format(date1)

    }


    fun getDateOnlyFromTimeStampForDietTitle(timestamp: Long): String {
        val date1 = Date(timestamp)
        val formatter = SimpleDateFormat("dd MMM")
        return formatter.format(date1)

    }




    fun currentdateTimeStamp(): String {
        var calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        val date: Date = calendar.time
        return date.time.toString()
    }

    fun getCurrentdateTime(): Date {
        var calendar = Calendar.getInstance()
        return calendar.time
    }

    fun currentdateTimeStampTodate(): String {
        var calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 12)
        calendar.set(Calendar.MINUTE, 59)
        calendar.set(Calendar.SECOND, 59)
        val date: Date = calendar.time
        return date.time.toString()
    }

    fun currentDateMedicationEndTimeStampToDate(): String {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 23)
        calendar.set(Calendar.MINUTE, 59)
        calendar.set(Calendar.SECOND, 59)
        val date: Date = calendar.time
        return date.time.toString()
    }

    fun currentdateTimeStampFromHour(): String {
        var calendar = Calendar.getInstance()
        val date: Date = calendar.time
        return date.time.toString()
    }

    fun getTimeStampStartDate(date: Date): String {
        val calendar = Calendar.getInstance()
        calendar.time = date
        val year = calendar[Calendar.YEAR]
        val month = calendar[Calendar.MONTH]
        val day = calendar[Calendar.DATE]
        calendar.set(Calendar.MILLISECOND, 0)
        calendar[year, month, day, 0, 0] = 0
        return calendar.time.time.toString()
    }

    fun getTimeStampEndDate(date: Date): String {
        val calendar = Calendar.getInstance()
        calendar.time = date
        val year = calendar[Calendar.YEAR]
        val month = calendar[Calendar.MONTH]
        val day = calendar[Calendar.DATE]
        calendar.set(Calendar.MILLISECOND, 0)
        calendar[year, month, day, 23, 59] = 59
        return calendar.time.time.toString()
    }

    fun getEndDate(date: Date): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date
        val year = calendar[Calendar.YEAR]
        val month = calendar[Calendar.MONTH]
        val day = calendar[Calendar.DATE]
        calendar.set(Calendar.MILLISECOND, 0)
        calendar[year, month, day, 23, 59] = 59
        return calendar.time
    }

    /**
     * This method calculate the 12 hours unix timestamp from current month date
     * to coming month date. Coming month date will be same as current date.
     * For example : If current date is (13 Feb, 2021) then coming month date
     * will be (13 March, 2021) in case of Upcoming type and for Past it'll be
     * 13 Jan, 2021
     *
     * @param type The details of appointments selected type
     * @return Epoch timestamp in milliseconds
     */


    /**
     * Convert Epoc timestamp to current date. Here 1000 is multiplied to get the current
     * date from the Unix timestamp.
     *
     *@return Epoc time format to current date format. e.g February 2,2021
     * */
    fun epochToDate(time: Long): String {
        val format = APPOINTMENTS_BOOKED_DATE_FORMAT
        val sdf = SimpleDateFormat(format, Locale.getDefault())
        sdf.timeZone = TimeZone.getDefault()
        return sdf.format(Date(time))
    }

    /**
     * Convert Epoc timestamp to time added. Here 1000 is multiplied to get the time
     * added from the Unix timestamp.
     *
     *@return Epoc time format to current time format. e.g 3:58 PM
     * */
    fun epochToTime(time: Long): String {
        val format = APPOINTMENTS_BOOKED_TIME_FORMAT
        val sdf = SimpleDateFormat(format, Locale.getDefault())
        sdf.timeZone = TimeZone.getDefault()
        return sdf.format(Date(time * 1000))
    }

    /**
     * Convert Epoc timestamp to time added. Here 1000 is multiplied to get the time
     * added from the Unix timestamp.
     *
     *@return Epoc time format to current time format. e.g 3:58 PM
     * */


    /**
     * Convert Epoc timestamp to current date. Here 1000 is multiplied to get the current
     * date from the Unix timestamp.
     *
     *@return Epoc time format to current date format. e.g February 2,2021
     * */


/*long secondInaDay = 60 * 60 * 24;
    long endOfTheDayEpoch = startOfTheDayEpoch + secondInaDay-1;*/

    fun getEpochDateTimeFromDate(timeInMillis: Long): String {
        val sdf = SimpleDateFormat("MMM dd, yyyy, hh:mm a", Locale.getDefault())
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timeInMillis
        return sdf.format(calendar.timeInMillis)
    }
}