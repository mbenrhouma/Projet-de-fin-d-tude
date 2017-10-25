package com.cynapsys.Views.Converter;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.NoteDebit;
import com.cynapsys.service.NoteDebitService;

	@ManagedBean
	@ApplicationScoped
	public class NoteDebitConverterBean {

		@ManagedProperty(value = "#{noteDebitService}")
		private NoteDebitService noteDebitService;
         
		
		public NoteDebitService getNoteDebitService() {
			return noteDebitService;
		}

		public void setNoteDebitService(NoteDebitService noteDebitService) {
			this.noteDebitService = noteDebitService;
		}




		@FacesConverter(value = "noteDebitConverter")
		public static class NoteDebitConverter implements Converter {

			@Override
			public Object getAsObject(FacesContext arg0, UIComponent arg1,
					String arg2) {
				NoteDebit noteDebit = new NoteDebit();
				if (arg2 != null && !String.valueOf(arg2).equals("")&& !arg2.contains("------------")) {
					NoteDebitConverterBean noteDebitConverterBean = (NoteDebitConverterBean) FacesContext
							.getCurrentInstance()
							.getApplication()
							.evaluateExpressionGet(
									FacesContext.getCurrentInstance(),
									"#{noteDebitConverterBean}",
									NoteDebitConverterBean.class);

					noteDebit = noteDebitConverterBean.getNoteDebitService().findById(arg2);


				}

				return noteDebit;
			}

			@Override
			public String getAsString(FacesContext arg0, UIComponent arg1,
					Object arg2) {
				Integer id = (arg2 instanceof NoteDebit) ? ((NoteDebit) arg2).getId() : null;
				
				return (id != null) ? String.valueOf(id) : null;
			}

		}
	}

