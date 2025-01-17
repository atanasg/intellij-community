// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.intellij.platform.backend.navigation.impl

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.backend.navigation.NavigationRequest
import com.intellij.platform.backend.navigation.NavigationRequests
import com.intellij.pom.Navigatable
import com.intellij.psi.PsiDirectory

internal class NavigationRequestsImpl : NavigationRequests {

  override fun sourceNavigationRequest(file: VirtualFile, offset: Int): NavigationRequest? {
    ApplicationManager.getApplication().assertReadAccessAllowed()
    ApplicationManager.getApplication().assertIsNonDispatchThread()
    if (!file.isValid) {
      return null
    }
    // TODO ? check if offset is within bounds
    return SourceNavigationRequest(file, offset)
  }

  override fun directoryNavigationRequest(directory: PsiDirectory): NavigationRequest? {
    ApplicationManager.getApplication().assertReadAccessAllowed()
    ApplicationManager.getApplication().assertIsNonDispatchThread()
    if (!directory.isValid) {
      return null
    }
    return DirectoryNavigationRequest(directory)
  }

  override fun rawNavigationRequest(navigatable: Navigatable): NavigationRequest? {
    ApplicationManager.getApplication().assertReadAccessAllowed()
    ApplicationManager.getApplication().assertIsNonDispatchThread()
    if (!navigatable.canNavigateToSource() && !navigatable.canNavigate()) {
      return null
    }
    return RawNavigationRequest(navigatable)
  }
}