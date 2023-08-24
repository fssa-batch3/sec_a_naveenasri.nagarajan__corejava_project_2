package com.fssa.dynamicdesign.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.dynamicdesign.dao.DesignDAO;
import com.fssa.dynamicdesign.dao.exception.DAOException;
import com.fssa.dynamicdesign.model.Design;
import com.fssa.dynamicdesign.service.exception.ServiceException;
import com.fssa.dynamicdesign.validation.DesignValidator;
import com.fssa.dynamicdesign.validation.exception.InvalidDesignException;

public class DesignService {

	// Create design Service code
	public boolean createDesign(Design design) throws ServiceException {

		DesignDAO designDAO = new DesignDAO();
		try {
			if (design == null) {
				throw new ServiceException("Design is null");
			}

			DesignValidator.validateDesign(design);
			
			designDAO.checkIdExistsInArchitect(design.getArchitectId());
			
			return designDAO.createDesign(design);
			
		} catch (DAOException | InvalidDesignException e) {
			throw new ServiceException(e);
		}
	}

	public List<Design> listDesigns() throws ServiceException {
		DesignDAO designDAO = new DesignDAO();

		try {
			return designDAO.listDesigns();
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}

	public boolean updateDesign(Design design) throws ServiceException {
		DesignDAO designDAO = new DesignDAO();

		try {
			if (design == null) {
				throw new InvalidDesignException("Design is null");
			}

			DesignValidator.validateDesign(design);

			return designDAO.updateDesign(design);
		} catch (SQLException | InvalidDesignException e) {
			throw new ServiceException(e);
		}
	}

	public boolean deleteDesign(int designId) throws ServiceException {
		DesignDAO designDAO = new DesignDAO();

		try {
			DesignValidator.validateDesignId(designId);
			return designDAO.deleteDesign(designId);
		} catch (SQLException | InvalidDesignException e) {
			throw new ServiceException(e);
		}
	}

}