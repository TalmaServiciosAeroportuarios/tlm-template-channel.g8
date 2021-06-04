package $package$.exceptions;

import lombok.extern.slf4j.Slf4j;
import pe.talma.commons.CatalogErrors;
import pe.talma.commons.exception.GenericRuntimeException;
import pe.talma.commons.exception.InternalException;

@Slf4j
public enum $application;format="Camel"$CatalogErrors implements CatalogErrors {

  $application;format="upper,word"$_E500_001(InternalException.class, "Error de validacion de DNI");

  private final GenericRuntimeException exception;

  $application;format="Camel"$CatalogErrors(Class<? extends GenericRuntimeException> exceptionClass, String systemMessage) {
    exception = getException(exceptionClass, systemMessage, name());
  }

  @Override
  public GenericRuntimeException getException() { return exception; }


}


