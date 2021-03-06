package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.namespace.QName;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.dataformat.xml.XmlAnnotationIntrospector;

public class AnnotationUtil
{
    public static String findNamespaceAnnotation(AnnotationIntrospector ai,
            AnnotatedMember prop)
    {
        for (AnnotationIntrospector intr : ai.allIntrospectors()) {
            if (intr instanceof XmlAnnotationIntrospector) {
                String ns = ((XmlAnnotationIntrospector) intr).findNamespace(prop);
                if (ns != null) {
                    return ns;
                }
            }
        }
        return null;
    }

    public static Boolean findIsAttributeAnnotation(AnnotationIntrospector ai,
            AnnotatedMember prop)
    {
        for (AnnotationIntrospector intr : ai.allIntrospectors()) {
            if (intr instanceof XmlAnnotationIntrospector) {
                Boolean b = ((XmlAnnotationIntrospector) intr).isOutputAsAttribute(prop);
                if (b != null) {
                    return b;
                }
            }
        }
        return null;
    }

    public static Boolean findIsTextAnnotation(AnnotationIntrospector ai,
            AnnotatedMember prop)
    {
        for (AnnotationIntrospector intr : ai.allIntrospectors()) {
            if (intr instanceof XmlAnnotationIntrospector) {
                Boolean b = ((XmlAnnotationIntrospector) intr).isOutputAsText(prop);
                if (b != null) {
                    return b;
                }
            }
        }
        return null;
    }
    
    public static QName findWrapperName(AnnotationIntrospector ai, AnnotatedMember prop)
    {
        for (AnnotationIntrospector intr : ai.allIntrospectors()) {
            if (intr instanceof XmlAnnotationIntrospector) {
                QName n = ((XmlAnnotationIntrospector) intr).findWrapperElement(prop);
                if (n != null) {
                    return n;
                }
            }
        }
        return null;
    }
}
