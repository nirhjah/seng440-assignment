package nz.ac.uclive.nse41.witsoc

class Event (val name: String,
              val startTime: String,
             val endTime: String,
             val eventType: String,
             val eventURL: String
             ) {
    override fun toString() = name
}