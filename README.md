eclipse_cmdhere
===

eclipse_cmdhere adds "Open Cmd window here..." and "Open Explorer window here..."
menu options when you select a single project, package, or source file.  The command prompt
will open in the directory of a selected project or package, or the directory containing a
selected source file.

Installation
---

Import the project into Eclipse.  Make sure you have the relevant extensions for Eclipse plugin development intsalled.  Double click on the plugin.xml manifest and, on the Overview tab, select "Export deployable plug-ins and fragments".  

Export it to your Eclipse dropins folder.

Limitations
---

I wrote this for my own personal use, and so it has only been tested on Eclipse 3.7-4.5.
