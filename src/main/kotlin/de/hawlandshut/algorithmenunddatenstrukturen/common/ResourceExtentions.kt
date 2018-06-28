package de.hawlandshut.algorithmenunddatenstrukturen.common

import java.io.File

fun fileFromResources(name : String) = File(Thread.currentThread().contextClassLoader.getResource(name).toURI())