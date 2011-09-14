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

public class OpenShellAction extends AbstractHandler {

    /**
     * Constructor for Action1.
     */
    public OpenShellAction() {
        super();
    }

    public Object execute(ExecutionEvent event) throws ExecutionException {
        IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getActiveMenuSelection(event);
        Object firstElement = selection.getFirstElement();
        if (firstElement instanceof ICompilationUnit) {
            ICompilationUnit cu = (ICompilationUnit) firstElement;
            launchShell(cu.getResource().getLocation());
        } else if (firstElement instanceof IPackageFragmentRoot ) {
            IPackageFragmentRoot  cu = (IPackageFragmentRoot ) firstElement;
            launchShell(cu.getResource().getLocation());
        } else if (firstElement instanceof IPackageFragment) {
            IPackageFragment cu = (IPackageFragment) firstElement;
            launchShell(cu.getResource().getLocation());
        } else if (firstElement instanceof IJavaProject) {
            IJavaProject cu = (IJavaProject) firstElement;
            launchShell(cu.getResource().getLocation());
        } else if (firstElement instanceof IResource) {
            IResource cu = (IResource) firstElement;
            launchShell(cu.getLocation());
        } else if (firstElement instanceof IType) {
            IType cu = (IType) firstElement;
            launchShell(cu.getResource().getLocation());
        } else {
            launchShell(null);
        }
        return null;
    }

    private void launchShell(IPath path) {
        String fullPath = findDirectoryFor(path);
        Runtime run = Runtime.getRuntime();
        StringBuilder cmd = new StringBuilder();
        if (path != null) {
            String drive = fullPath.substring(0, 2);
            cmd.append("cmd.exe /c \"" + drive + " && cd \"" + fullPath + "\" && start cmd.exe\"");
        } else {
            cmd.append("cmd.exe /c start cmd.exe");
        }
        try {
            run.exec(cmd.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param path where a given resource is located
     * @return the OS-specific file system path to a resource within Eclipse; if the resource
     * is a file, the directory containing it is returned instead  
     */
    private String findDirectoryFor(IPath path) {
        String fullPath = path.toOSString();
        File file = path.toFile();
        if (!file.isDirectory()) {
            fullPath = file.getParent();
        }
        return fullPath;
    }
}
