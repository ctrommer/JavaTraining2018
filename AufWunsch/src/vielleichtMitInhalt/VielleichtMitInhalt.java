package vielleichtMitInhalt;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public final class VielleichtMitInhalt<T> {
    /**
     * Common instance for {@code empty()}.
     */
	private static final VielleichtMitInhalt<?> INHALTNULL = new VielleichtMitInhalt<>();

    /**
     * If non-null, the value; if null, indicates no value is present
     */
	private final T inhalt;

    /**
     * Constructs an empty instance.
     *
     * @implNote Generally only one empty instance, {@link Optional#EMPTY},
     * should exist per VM.
     */
	private VielleichtMitInhalt() {
		this.inhalt = null;
	} 

    /**
     * Returns an empty {@code Optional} instance.  No value is present for this
     * Optional.
     *
     * @apiNote Though it may be tempting to do so, avoid testing if an object
     * is empty by comparing with {@code ==} against instances returned by
     * {@code Option.empty()}. There is no guarantee that it is a singleton.
     * Instead, use {@link #isPresent()}.
     *
     * @param <T> Type of the non-existent value
     * @return an empty {@code Optional}
     */
	public static <T> VielleichtMitInhalt<T> leereInstanz() {
		@SuppressWarnings("unchecked")
		VielleichtMitInhalt<T> mitInhaltNull = (VielleichtMitInhalt<T>) INHALTNULL;
		return mitInhaltNull;
	}

    /**
     * Constructs an instance with the value present.
     *
     * @param value the non-null value to be present
     * @throws NullPointerException if value is null
     */
	private VielleichtMitInhalt(T inhalt) {
		this.inhalt = Objects.requireNonNull( inhalt );
	}

    /**
     * Returns an {@code Optional} with the specified present non-null value.
     *
     * @param <T> the class of the value
     * @param value the value to be present, which must be non-null
     * @return an {@code Optional} with the value present
     * @throws NullPointerException if value is null
     */
	public static <T> VielleichtMitInhalt<T> erzeugeAus(T inhalt) {
		return new VielleichtMitInhalt<>(inhalt);
	}

    /**
     * Returns an {@code Optional} describing the specified value, if non-null,
     * otherwise returns an empty {@code Optional}.
     *
     * @param <T> the class of the value
     * @param value the possibly-null value to describe
     * @return an {@code Optional} with a present value if the specified value
     * is non-null, otherwise an empty {@code Optional}
     */
	public static <T> VielleichtMitInhalt<T> erzeugeAusNullErlaubt(T inhalt) {
		return inhalt == null ? leereInstanz() : erzeugeAus(inhalt);
	}

    /**
     * If a value is present in this {@code Optional}, returns the value,
     * otherwise throws {@code NoSuchElementException}.
     *
     * @return the non-null value held by this {@code Optional}
     * @throws NoSuchElementException if there is no value present
     *
     * @see Optional#isPresent()
     */
	public T getInhalt() {
		if ( inhalt == null ) { throw new NoSuchElementException(); }
		return inhalt;
	}

    /**
     * Return {@code true} if there is a value present, otherwise {@code false}.
     *
     * @return {@code true} if there is a value present, otherwise {@code false}
     */
	public boolean istInhaltVorhanden() {
		return inhalt != null;
	}

    /**
     * If a value is  not present, returns {@code true}, otherwise
     * {@code false}.
     *
     * @return  {@code true} if a value is not present, otherwise {@code false}
     * @since   11
     */
    public boolean istLeer() {
        return inhalt == null;
    }

    /**
     * If a value is present, invoke the specified consumer with the value,
     * otherwise do nothing.
     *
     * @param consumer block to be executed if a value is present
     * @throws NullPointerException if value is present and {@code consumer} is
     * null
     */
	public void wennInhaltDannMache( Benutzer<? super T> benutzer ) {
		if ( inhalt != null ) {
			benutzer.machWasMit( inhalt );			
		}
	}

    /**
     * If a value is present, performs the given action with the value,
     * otherwise performs the given empty-based action.
     *
     * @param benutzer the action to be performed, if a value is present
     * @param lauffaehig the empty-based action to be performed, if no value is
     *        present
     * @throws NullPointerException if a value is present and the given action
     *         is {@code null}, or no value is present and the given empty-based
     *         action is {@code null}.
     * @since 9
     */
    public void wennVorhandenBenutzerSonstLauffaehig( 
												Benutzer<? super T> benutzer, 
												Lauffaehig lauffaehig ) {
        if ( inhalt != null ) {
            benutzer.machWasMit( inhalt );
        } else {
            lauffaehig.laufe();
        }
    }
	
    /**
     * If a value is present, and the value matches the given predicate,
     * return an {@code Optional} describing the value, otherwise return an
     * empty {@code Optional}.
     *
     * @param predicate a predicate to apply to the value, if present
     * @return an {@code Optional} describing the value of this {@code Optional}
     * if a value is present and the value matches the given predicate,
     * otherwise an empty {@code Optional}
     * @throws NullPointerException if the predicate is null
     */
	public VielleichtMitInhalt<T> filtere( Bedingung<? super T> bedingung) {
		Objects.requireNonNull(bedingung);
		if ( istInhaltVorhanden() ) { 
			return bedingung.istErfuelltFuer(inhalt) ? this : leereInstanz();
		} else {
			return this;
		}
	}

    /**
     * If a value is present, apply the provided mapping function to it,
     * and if the result is non-null, return an {@code Optional} describing the
     * result.  Otherwise return an empty {@code Optional}.
     *
     * @apiNote This method supports post-processing on optional values, without
     * the need to explicitly check for a return status.  For example, the
     * following code traverses a stream of file names, selects one that has
     * not yet been processed, and then opens that file, returning an
     * {@code Optional<FileInputStream>}:
     *
     * <pre>{@code
     *     Optional<FileInputStream> fis =
     *         names.stream().filter(name -> !isProcessedYet(name))
     *                       .findFirst()
     *                       .map(name -> new FileInputStream(name));
     * }</pre>
     *
     * Here, {@code findFirst} returns an {@code Optional<String>}, and then
     * {@code map} returns an {@code Optional<FileInputStream>} for the desired
     * file if one exists.
     *
     * @param <U> The type of the result of the mapping function
     * @param mapper a mapping function to apply to the value, if present
     * @return an {@code Optional} describing the result of applying a mapping
     * function to the value of this {@code Optional}, if a value is present,
     * otherwise an empty {@code Optional}
     * @throws NullPointerException if the mapping function is null
     */
	public <U> VielleichtMitInhalt<U> transformiere( Transformierer<? super T, ? extends U> transformierer ) {
		Objects.requireNonNull(transformierer);
		if ( !istInhaltVorhanden() ) {
			return leereInstanz();
		} else {
			return  erzeugeAusNullErlaubt(transformierer.transformiere(inhalt));
		}
	}

    /**
     * If a value is present, apply the provided {@code Optional}-bearing
     * mapping function to it, return that result, otherwise return an empty
     * {@code Optional}.  This method is similar to {@link #map(Function)},
     * but the provided mapper is one whose result is already an {@code Optional},
     * and if invoked, {@code flatMap} does not wrap it with an additional
     * {@code Optional}.
     *
     * @param <U> The type parameter to the {@code Optional} returned by
     * @param mapper a mapping function to apply to the value, if present
     *           the mapping function
     * @return the result of applying an {@code Optional}-bearing mapping
     * function to the value of this {@code Optional}, if a value is present,
     * otherwise an empty {@code Optional}
     * @throws NullPointerException if the mapping function is null or returns
     * a null result
     */
	public <U> VielleichtMitInhalt<U> transformiereFlach( Transformierer<? super T,VielleichtMitInhalt<U>> transformierer ) {
		Objects.requireNonNull(transformierer);
		if ( !istInhaltVorhanden() ) {
			return leereInstanz();
		} else {
			return Objects.requireNonNull(transformierer.transformiere(inhalt));
		}
	}

    /**
     * If a value is present, returns an {@code Optional} describing the value,
     * otherwise returns an {@code Optional} produced by the supplying function.
     *
     * @param supplier the supplying function that produces an {@code Optional}
     *        to be returned
     * @return returns an {@code Optional} describing the value of this
     *         {@code Optional}, if a value is present, otherwise an
     *         {@code Optional} produced by the supplying function.
     * @throws NullPointerException if the supplying function is {@code null} or
     *         produces a {@code null} result
     * @since 9
     */
    public VielleichtMitInhalt<T> inhaltOderErzeuge( 
    								Erzeuger<? extends VielleichtMitInhalt<? extends T>> erzeuger ) {
        Objects.requireNonNull( erzeuger );
        if ( istInhaltVorhanden() ) {
            return this;
        } else {
            @SuppressWarnings( "unchecked" )
            VielleichtMitInhalt<T> r = ( VielleichtMitInhalt<T> ) erzeuger.erzeuge();
            return Objects.requireNonNull( r );
        }
    }
	
    /**
     * If a value is present, returns a sequential {@link Stream} containing
     * only that value, otherwise returns an empty {@code Stream}.
     *
     * @apiNote
     * This method can be used to transform a {@code Stream} of optional
     * elements to a {@code Stream} of present value elements:
     * <pre>{@code
     *     Stream<Optional<T>> os = ..
     *     Stream<T> s = os.flatMap(Optional::stream)
     * }</pre>
     *
     * @return the optional value as a {@code Stream}
     * @since 9
     */
    public Stream<T> erzeugeStream() {
        if ( !istInhaltVorhanden() ) {
            return Stream.empty();
        } else {
            return Stream.of( inhalt );
        }
    }
	
    /**
     * Return the value if present, otherwise return {@code other}.
     *
     * @param other the value to be returned if there is no value present, may
     * be null
     * @return the value, if present, otherwise {@code other}
     */
	public T holeWennVorhandenSonst( T defaultInhalt ) {
		return istInhaltVorhanden() ? inhalt : defaultInhalt;		
	}

    /**
     * Return the value if present, otherwise invoke {@code other} and return
     * the result of that invocation.
     *
     * @param other a {@code Supplier} whose result is returned if no value
     * is present
     * @return the value if present otherwise the result of {@code other.get()}
     * @throws NullPointerException if value is not present and {@code other} is
     * null
     */
	public T holeWennVorhandenSonstRufeAuf( Erzeuger<? extends T> erzeuger ) {
		return istInhaltVorhanden() ? inhalt : erzeuger.erzeuge();
	}

    /**
     * If a value is present, returns the value, otherwise throws
     * {@code NoSuchElementException}.
     *
     * @return the non-{@code null} value described by this {@code Optional}
     * @throws NoSuchElementException if no value is present
     * @since 10
     */
    public T wertOderException() {
        if ( inhalt == null ) {
            throw new NoSuchElementException("No value present");
        }
        return inhalt;
    }

    /**
     * Return the contained value, if present, otherwise throw an exception
     * to be created by the provided supplier.
     *
     * @apiNote A method reference to the exception constructor with an empty
     * argument list can be used as the supplier. For example,
     * {@code IllegalStateException::new}
     *
     * @param <X> Type of the exception to be thrown
     * @param exceptionSupplier The supplier which will return the exception to
     * be thrown
     * @return the present value
     * @throws X if there is no value present
     * @throws NullPointerException if no value is present and
     * {@code exceptionSupplier} is null
     */
	public <X extends Throwable> T holeWennVorhandenSonstWerfeException( Erzeuger<X> ausnameErzeuger ) throws X {
		if ( istInhaltVorhanden() ) {
			return inhalt;
		} else {
			throw ausnameErzeuger.erzeuge();
		}
	}

    /**
     * Indicates whether some other object is "equal to" this Optional. The
     * other object is considered equal if:
     * <ul>
     * <li>it is also an {@code Optional} and;
     * <li>both instances have no value present or;
     * <li>the present values are "equal to" each other via {@code equals()}.
     * </ul>
     *
     * @param obj an object to be tested for equality
     * @return {code true} if the other object is "equal to" this object
     * otherwise {@code false}
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (!(obj instanceof VielleichtMitInhalt)) {
			return false;
		}
		
		VielleichtMitInhalt<?> rechts = (VielleichtMitInhalt<?>) obj;
		
		return Objects.equals(inhalt, rechts.inhalt);		
	}
	

    /**
     * Returns the hash code value of the present value, if any, or 0 (zero) if
     * no value is present.
     *
     * @return hash code value of the present value or 0 if no value is present
     */
	@Override
	public int hashCode() {
		return Objects.hashCode(inhalt);
	}



    /**
     * Returns a non-empty string representation of this Optional suitable for
     * debugging. The exact presentation format is unspecified and may vary
     * between implementations and versions.
     *
     * @implSpec If a value is present the result must include its string
     * representation in the result. Empty and present Optionals must be
     * unambiguously differentiable.
     *
     * @return the string representation of this instance
     */
	@Override
	public String toString() {
		return istInhaltVorhanden() ? "VielleichtMitInhalt [inhalt=" + inhalt + "]" : "VielleichtMitInhalt:leer"; 
	}
	

}
