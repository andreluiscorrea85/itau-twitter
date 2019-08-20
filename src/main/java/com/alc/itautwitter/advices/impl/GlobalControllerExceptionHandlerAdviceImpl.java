package com.alc.itautwitter.advices.impl;

import com.alc.itautwitter.advices.base.AbstractItauTwitterControllerExceptionHandlerAdvice;
import com.alc.itautwitter.controller.base.ItauTwitterController;
import com.alc.itautwitter.exceptions.impl.ItauTwitterException;
import com.alc.itautwitter.helper.constants.ItauTwitterConstants;
import org.springframework.beans.BeansException;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.PropertyAccessException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.NestedRuntimeException;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.util.NestedServletException;

import javax.lang.model.UnknownEntityException;
import javax.lang.model.element.UnknownAnnotationValueException;
import javax.lang.model.element.UnknownElementException;
import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.MirroredTypesException;
import javax.lang.model.type.UnknownTypeException;
import javax.servlet.ServletException;
import java.lang.annotation.AnnotationFormatError;
import java.lang.annotation.AnnotationTypeMismatchException;
import java.lang.annotation.IncompleteAnnotationException;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.UnmodifiableClassException;
import java.lang.invoke.LambdaConversionException;
import java.lang.invoke.WrongMethodTypeException;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.MalformedParametersException;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * The type Global controller exception handler advice.
 */
@ControllerAdvice(basePackageClasses = ItauTwitterController.class)
@RequestMapping(produces = {ItauTwitterConstants.APPLICATION_VND_ERROR_JSON} )
public final class GlobalControllerExceptionHandlerAdviceImpl
	extends AbstractItauTwitterControllerExceptionHandlerAdvice {

	private static final long serialVersionUID = 660364534414364552L;

	/**
	 * Instantiates a new Global controller exception handler advice.
	 */
	public GlobalControllerExceptionHandlerAdviceImpl() {
		super();

		this.initObject();
	}

	/**
	 * Init object.
	 */
	@Override()
	protected void initObject() {

	}

	/**
	 * Handle exception response entity.
	 *
	 * @param <E>       the type parameter
	 * @param exception the exception
	 *
	 * @return the response entity
	 */
	@ExceptionHandler(
		value={
			Throwable.class,
				Error.class,
					LinkageError.class,
						AnnotationFormatError.class,
						AssertionError.class,
						BootstrapMethodError.class,
						ClassCircularityError.class,
						ClassFormatError.class,
							GenericSignatureFormatError.class,
							UnsupportedClassVersionError.class,
						ExceptionInInitializerError.class,
						IncompatibleClassChangeError.class,
							AbstractMethodError.class,
							IllegalAccessError.class,
							InstantiationError.class,
							NoSuchFieldError.class,
							NoSuchMethodError.class,
						NoClassDefFoundError.class,
						UnsatisfiedLinkError.class,
						VerifyError.class,
					VirtualMachineError.class,
						InternalError.class,
						OutOfMemoryError.class,
						StackOverflowError.class,
						UnknownError.class,
				Exception.class,
					BindException.class,
					CloneNotSupportedException.class,
					IllegalClassFormatException.class,
					IllegalMonitorStateException.class,
					IllegalStateException.class,
					InterruptedException.class,
					LambdaConversionException.class,
					MethodArgumentNotValidException.class,
					MirroredTypesException.class,
						MirroredTypeException.class,
					NegativeArraySizeException.class,
					NestedRuntimeException.class,
						BeansException.class,
							PropertyAccessException.class,
								TypeMismatchException.class,
									ConversionNotSupportedException.class,
						HttpMessageConversionException.class,
							HttpMessageNotReadableException.class,
							HttpMessageNotWritableException.class,
					NullPointerException.class,
					ReflectiveOperationException.class,
						ClassNotFoundException.class,
						IllegalAccessException.class,
						InstantiationException.class,
						InvocationTargetException.class,
						NoSuchFieldException.class,
						NoSuchMethodException.class,
					RuntimeException.class,
						AnnotationTypeMismatchException.class,
						ArithmeticException.class,
						ArrayStoreException.class,
						AsyncRequestTimeoutException.class,
						ClassCastException.class,
						EnumConstantNotPresentException.class,
						IllegalArgumentException.class,
							NumberFormatException.class,
							IllegalThreadStateException.class,
						IncompleteAnnotationException.class,
						IndexOutOfBoundsException.class,
							StringIndexOutOfBoundsException.class,
							ArrayIndexOutOfBoundsException.class,
						MalformedParameterizedTypeException.class,
						MalformedParametersException.class,
						SecurityException.class,
						TypeNotPresentException.class,
						UnsupportedOperationException.class,
						WrongMethodTypeException.class,
					ServletException.class,
						//NoSuchRequestHandlingMethodException.class,
						HttpRequestMethodNotSupportedException.class,
						HttpMediaTypeException.class,
							HttpMediaTypeNotSupportedException.class,
							HttpMediaTypeNotAcceptableException.class,
						NestedServletException.class,
							ServletRequestBindingException.class,
								MissingPathVariableException.class,
								MissingServletRequestParameterException.class,
						MissingServletRequestPartException.class,
						NoHandlerFoundException.class,
					UndeclaredThrowableException.class,
					UnknownEntityException.class,
						UnknownAnnotationValueException.class,
						UnknownElementException.class,
						UnknownTypeException.class,
					UnmodifiableClassException.class,
				ItauTwitterException.class
		}
	)
	@Override()
	public <E extends Throwable> ResponseEntity<VndErrors> handleException(final E exception) {
		return super.handleException(exception);
	}

	/**
	 * Hash code int.
	 *
	 * @return the int
	 */
	@Override()
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * Equals boolean.
	 *
	 * @param object the object
	 *
	 * @return the boolean
	 */
	@Override()
	public boolean equals(final Object object) {
		return super.equals(object);
	}

	/**
	 * To string string.
	 *
	 * @return the string
	 */
	@Override()
	public String toString() {
		return super.toString();
	}

}
