package de.metas.inoutcandidate.spi.impl;

import javax.annotation.Nullable;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.model.InterfaceWrapperHelper;

import de.metas.handlingunits.model.I_M_InOutLine;
import de.metas.handlingunits.model.I_M_MovementLine;
import lombok.experimental.UtilityClass;

/*
 * #%L
 * de.metas.handlingunits.base
 * %%
 * Copyright (C) 2017 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

@UtilityClass
public final class HUPackingMaterialCollectorSourceFactory
{
	public static IHUPackingMaterialCollectorSource fromNullable(@Nullable final Object model)
	{
		if (model == null)
		{
			return null;
		}
		else if (InterfaceWrapperHelper.isInstanceOf(model, I_M_InOutLine.class))
		{
			I_M_InOutLine inoutLine = InterfaceWrapperHelper.create(model, I_M_InOutLine.class);
			return new InOutLineHUPackingMaterialCollectorSource(inoutLine);
		}
		else if (InterfaceWrapperHelper.isInstanceOf(model, I_M_MovementLine.class))
		{
			I_M_MovementLine movementLine = InterfaceWrapperHelper.create(model, I_M_MovementLine.class);
			return new MovementLineHUPackingMaterialCollectorSource(movementLine);
		}
		else
		{
			// TODO
			throw new AdempiereException("Cannot create " + IHUPackingMaterialCollectorSource.class + " for " + model);
		}
	}
}
