/*
 * Copyright (c) 2021 D4L data4life gGmbH / All rights reserved.
 *
 * D4L owns all legal rights, title and interest in and to the Software Development Kit ("SDK"),
 * including any intellectual property rights that subsist in the SDK.
 *
 * The SDK and its documentation may be accessed and used for viewing/review purposes only.
 * Any usage of the SDK for other purposes, including usage for the development of
 * applications/third-party applications shall require the conclusion of a license agreement
 * between you and D4L.
 *
 * If you are interested in licensing the SDK for your own applications/third-party
 * applications and/or if you’d like to contribute to the development of the SDK, please
 * contact D4L by email to help@data4life.care.
 */

package care.data4life.sdk.util.test

import java.io.File
import care.data4life.sdk.util.test.lang.FileNotFoundError

actual class CommonResourceLoader actual constructor(projectDir: AbsolutePath) {
    private val projectPath = projectDir

    private fun resolveRoot(root: Path?): Path {
        return if (root is Path) {
            root.trimEnd('/')
        } else {
            Constants.commonRoot
        }
    }

    actual fun exists(path: Path, root: Path?): Boolean {
        val resource = File(
            "${resolveRoot(root)}/${path.trimStart('/')}"
        )

        return resource.exists()
    }

    @Throws(FileNotFoundError::class)
    actual fun load(path: Path, root: Path?): String = TODO()
}
