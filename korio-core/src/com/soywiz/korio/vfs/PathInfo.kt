package com.soywiz.korio.vfs

import com.soywiz.korio.util.indexOfOrNull

class PathInfo(val fullpath: String) {
	val fullpathNormalized: String = fullpath.replace('\\', '/')
	val folder: String by lazy {
		fullpath.substring(0, fullpathNormalized.indexOfOrNull('/') ?: 0)
	}
	val basename: String by lazy { fullpathNormalized.substringAfterLast('/') }
	val pathWithoutExtension: String by lazy {
		fullpath.substring(0, fullpathNormalized.indexOfOrNull('.') ?: fullpathNormalized.length)
	}
	fun pathWithExtension(ext: String): String = if (ext.isEmpty()) pathWithoutExtension else "$pathWithoutExtension.$ext"
	val basenameWithoutExtension: String by lazy { basename.substringBeforeLast('.', basename) }
	fun basenameWithExtension(ext: String): String = if (ext.isEmpty()) pathWithoutExtension else "$pathWithoutExtension.$ext"
	val extension: String by lazy { basename.substringAfterLast('.', "") }
	val extensionLC: String by lazy { extension.toLowerCase() }
}