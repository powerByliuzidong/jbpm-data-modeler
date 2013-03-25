package org.jbpm.datamodeler.editor.client.editors;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import org.jbpm.datamodeler.editor.model.ObjectPropertyTO;

import java.util.HashSet;
import java.util.Set;

import static com.google.gwt.dom.client.BrowserEvents.CLICK;
import static com.google.gwt.dom.client.BrowserEvents.KEYDOWN;

public class PropertyTypeCell extends TextCell {

    private boolean navigable = false;
    
    DataObjectEditor editor;

    public PropertyTypeCell(boolean navigable, DataObjectEditor editor) {
        super();        
        this.navigable = navigable;
        this.editor = editor;
    }

    @Override
    public Set<String> getConsumedEvents() {
        Set<String> consumedEvents = new HashSet<String>();
        consumedEvents.add(CLICK);
        return consumedEvents;
    }

    @Override
    public void onBrowserEvent(Context context, Element parent, String value, NativeEvent event, ValueUpdater<String> stringValueUpdater) {

        Window.alert("cliqueando: " + context);
        ObjectPropertyTO property = (ObjectPropertyTO)context.getKey();
        
        if (DOM.eventGetType((Event) event) == Event.ONCLICK && !property.isBaseType()) {
            Command command = editor.getModelEditorPresenter().createSelectTypeCommand(property.getClassName());
            command.execute();
        } else {
           super.onBrowserEvent(context, parent, value, event, stringValueUpdater);
        }
    }

    @Override
    public void render(Context context, SafeHtml value, SafeHtmlBuilder sb) {

        ObjectPropertyTO property = (ObjectPropertyTO)context.getKey();
        if (navigable && property != null && !property.isBaseType()) {
            SafeHtml startAnchor = null;
            SafeHtml endAnchor = null;
            startAnchor = new SafeHtml() {
                @Override
                public String asString() {
                    return "<div style=\"cursor: pointer;\">";
                }
            };

            endAnchor = new SafeHtml() {
                @Override
                public String asString() {
                    return "</div>";
                }
            };

            sb.append(startAnchor);
            sb.append(value);
            sb.append(endAnchor);

        } else {
            super.render(context, value, sb);
        }
    }
}
