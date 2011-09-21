package org.metatrope.cmdhere.popup.actions;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

public class OpenExplorerAction extends CommandExecutingAction {

    /**
     * Constructor for OpenExplorerAction.
     */
    public OpenExplorerAction() {
        super();
    }

    public String getCommand(String fullPath) {
        StringBuilder cmd = new StringBuilder();
        if (fullPath != null) {
            cmd.append("explorer.exe \"" + fullPath + "\"");
        } else {
            cmd.append("explorer.exe");
        }
        return cmd.toString();
    }
}
