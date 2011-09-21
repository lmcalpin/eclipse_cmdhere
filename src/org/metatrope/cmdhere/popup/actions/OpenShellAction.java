package org.metatrope.cmdhere.popup.actions;


public class OpenShellAction extends CommandExecutingAction {

    /**
     * Constructor for OpenShellAction.
     */
    public OpenShellAction() {
        super();
    }

    public String getCommand(String fullPath) {
        StringBuilder cmd = new StringBuilder();
        if (fullPath != null) {
            String drive = fullPath.substring(0, 2);
            cmd.append("cmd.exe /c \"" + drive + " && cd \"" + fullPath + "\" && start cmd.exe\"");
        } else {
            cmd.append("cmd.exe /c start cmd.exe");
        }
        return cmd.toString();
    }
}
