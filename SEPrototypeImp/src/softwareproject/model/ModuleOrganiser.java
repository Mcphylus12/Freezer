package softwareproject.model;

import java.util.ArrayList;
import java.util.Arrays;

public class ModuleOrganiser {
    private ArrayList<Module> modules;
    private String name;

    public ModuleOrganiser(String name, ArrayList<Module> modules) {
        this.modules = modules;
        this.name = name;
    }
    
    public ModuleOrganiser(Module ... modules){
        this.modules = new ArrayList(Arrays.asList(modules));
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }
    
    public void addModule(Module m){
        modules.add(m);
    }
    
    public void removeModule(Module m){
        modules.remove(m);
    }
}