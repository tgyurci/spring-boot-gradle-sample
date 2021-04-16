@file:JvmName("SampleMain")

package sample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SampleApp

fun main(vararg args: String) {
    runApplication<SampleApp>(*args)
}
