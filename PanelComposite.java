
public class PanelComposite extends CustomComponent {

	private HorizontalLayout header ;
	private VerticalLayout body;
	private HorizontalLayout footer ;
	
	private HorizontalLayout headerLayout;
	private HorizontalLayout footerLayout;
	private Label tituloLbl;
	
	public PanelComposite(String titulo) 
		{
			tituloLbl = new Label(titulo);
			init();
			
		}

	public PanelComposite() 
	{
		tituloLbl = new Label();
		
		init();
		
	}
	
	public void setTitulo(String titulo)
	{
		tituloLbl.setValue(titulo);
	}
	
	private void init() {
		VerticalLayout root = new VerticalLayout();
		
		header = new HorizontalLayout();
		
		
		tituloLbl.setStyleName("titlePanel");
		header.addComponent(tituloLbl);
		headerLayout= new HorizontalLayout();
		header.addComponent(headerLayout);

		header.setComponentAlignment(headerLayout, Alignment.MIDDLE_RIGHT);
		
		header.setStyleName("headerPanel");
		header.setWidth("100%");
		header.setHeight("50px");
		
		body = new VerticalLayout();
		body.setStyleName("bodyPanel");
		body.setWidth("100%");
		
		footer = new HorizontalLayout();
		footer.setStyleName("footerPanel");
		footerLayout= new HorizontalLayout();
		footer.addComponent(footerLayout);
		footer.setComponentAlignment(footerLayout, Alignment.MIDDLE_CENTER);
		
		footer.setWidth("100%");
		footer.setHeight("60px");
		
		root.addComponent(header);
		root.addComponent(body);
		root.addComponent(footer);
		
		root.setWidth("100%");

		setCompositionRoot(root);
	}
	
	
	public void addComponentHeader(AbstractComponent component)
	{
		headerLayout.addComponent(UIUtils.generateH10Space());
		headerLayout.addComponent(component);
	}
	
	public void addContent(AbstractComponent component)
	{
		body.addComponent(component);
	}
	
	public void addComponentFooter(AbstractComponent component)
	{
		footerLayout.addComponent(component);
		footerLayout.addComponent(UIUtils.generateH10Space());
	}
	
	public void hideFooter()
	{
		footer.setVisible(false);
	}
	
	public void showFooter()
	{
		footer.setVisible(true);
	}
}
