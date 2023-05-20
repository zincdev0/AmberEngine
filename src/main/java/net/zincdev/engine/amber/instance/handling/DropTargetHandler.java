package net.zincdev.engine.amber.instance.handling;

import net.zincdev.engine.amber.instance.EngineInstance;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;
import java.io.File;
import java.util.List;

public class DropTargetHandler implements DropTargetListener {
    private final EngineInstance PARENT;

    public DropTargetHandler(EngineInstance parent) {
        this.PARENT = parent;
    }

    @Override public void dragEnter(DropTargetDragEvent e) {

    }

    @Override public void dragOver(DropTargetDragEvent e) {

    }

    @Override public void dropActionChanged(DropTargetDragEvent e) {

    }

    @Override public void dragExit(DropTargetEvent e) {

    }

    @Override public void drop(DropTargetDropEvent e) {
        e.acceptDrop(DnDConstants.ACTION_COPY);
        Transferable transferable = e.getTransferable();
        DataFlavor[] flavors = transferable.getTransferDataFlavors();

        for(DataFlavor flavor : flavors) {
            try {
                if(flavor.isFlavorJavaFileListType()) {
                    List<File> files = (List<File>)transferable.getTransferData(flavor);
                    for(File file : files) {
                        this.PARENT.$EventFileDropped.InvokeEvents((event) -> event.Invoke(file));
                    }
                }
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        e.dropComplete(true);
    }
}
