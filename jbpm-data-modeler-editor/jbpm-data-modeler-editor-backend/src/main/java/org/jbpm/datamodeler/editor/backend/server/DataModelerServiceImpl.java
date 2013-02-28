package org.jbpm.datamodeler.editor.backend.server;

import org.jboss.errai.bus.server.annotations.Service;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.service.DataModelerService;
import org.kie.commons.java.nio.file.OpenOption;
import org.kie.commons.java.nio.file.StandardOpenOption;
import org.uberfire.backend.vfs.Path;
import org.uberfire.backend.server.util.Paths;

import org.kie.commons.io.IOService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@ApplicationScoped
public class DataModelerServiceImpl implements DataModelerService {

    @Inject
    @Named("ioStrategy")
    IOService ioService;

    @Inject
    private Paths paths;

    public DataModelerServiceImpl() {
    }

    @Override
    public DataModelTO loadModel(Path path) {
        System.out.println("read this path: " + path);

        try {

            final String content = ioService.readAllString( paths.convert( path ) );

            System.out.println("the file content is: " + content);


        } catch (Exception e) {
            e.printStackTrace();
        }


        //TODO: implement the correct model loading
        DataModelTO dataModel = new DataModelTO("TestModel");
        List<DataObjectTO> dataObjects = new ArrayList<DataObjectTO>();
        for (int i=0; i< 10 ; i++) {
            dataObjects.add(new DataObjectTO(i));
        }
        dataModel.setDataObjects(dataObjects);

        return dataModel;
    }

    @Override
    public void saveModel(DataModelTO dataModel, Path path) {

        try {

            String content = ioService.readAllString( paths.convert( path ) );

            content = content + " - file was saved at: " + new Date();

            ioService.write(paths.convert(path), content);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Path createModel(Path context, String fileName) {

        org.kie.commons.java.nio.file.Path kiePath = paths.convert( context ).resolve( fileName );

        //create the file
        ioService.createFile(kiePath);
        
        ioService.write(kiePath, "The file was created at: " + new Date());


        final Path path = paths.convert(kiePath, false);

        return path;
    }
}